package com.shuttle.major.service.implement;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shuttle.major.common.logger.LoggerHelper;
import com.shuttle.major.config.exception.BusinessException;
import com.shuttle.major.entity.Category;
import com.shuttle.major.fetch.ServiceFetch;
import com.shuttle.major.mapper.CategoryMapper;
import com.shuttle.major.service.CategoryService;
import com.shuttle.major.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.beans.Transient;
import java.util.List;
import java.util.Map;

/**
 * @description: 类别服务实现类
 * @author: DHY
 * @created: 2020/10/30 13:41
 */
@Log4j2
@Service
public class CategoryServiceImp implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Resource
    private StoreServiceImp storeServiceImp;

    @Resource
    private ServiceFetch serviceFetch;

    /**
     * 添加类别
     *
     * @param category 类别
     */
    @Override
    @Transient
    @CacheEvict(value = "category", allEntries = true)
    public void insert(Category category) {
        boolean exist = (boolean) serviceFetch.exist(category.getServiceId()).getData();
        if (!exist) throw new BusinessException(0, "serviceId不存在");
        int res = categoryMapper.insert(category);
        log.info(LoggerHelper.logger(category, res));
        BusinessException.check(res, "添加失败");
    }

    /**
     * 删除类别
     *
     * @param id 类别id
     */
    @Override
    @Transient
    @CacheEvict(value = "category", allEntries = true)
    public void delete(long id) {
        int res = categoryMapper.delete(id, "id");
        storeServiceImp.deleteByCategoryId(id);
        log.info(LoggerHelper.logger(id, res));
        BusinessException.check(res, "删除失败");
    }

    /**
     * 根据服务id删除类别
     *
     * @param serviceId 服务id
     */
    @Transient
    @CacheEvict(value = "category", allEntries = true)
    public void deleteByServiceId(long serviceId) {
        for (Category category : findAllByServiceId(serviceId)) storeServiceImp.deleteByCategoryId(category.getId());
        int res = categoryMapper.delete(serviceId, "serviceId");
        log.info(LoggerHelper.logger(serviceId, res));
    }

    /**
     * 更新类别
     *
     * @param category 类别
     */
    @Override
    @Transient
    @CacheEvict(value = "category", allEntries = true)
    public void update(Category category) {
        boolean exist = (boolean) serviceFetch.exist(category.getServiceId()).getData();
        if (!exist) throw new BusinessException(0, "serviceId不存在");
        int res = categoryMapper.update(category);
        log.info(LoggerHelper.logger(category, res));
        BusinessException.check(res, "更新失败");
    }

    /**
     * 查询全部类别
     *
     * @return 类别列表
     */
    @Override
    @Cacheable(value = "category", key = "methodName + #option.toString()")
    public PageInfo<Category> findAll(Map<String, String> option) {
        Utils.checkOption(option, Category.class);
        String orderBy = String.format("category.%s %s", option.get("sort"), option.get("order"));
        PageHelper.startPage(Integer.parseInt(option.get("pageNo")), Integer.parseInt(option.get("pageSize")), orderBy);
        return PageInfo.of(categoryMapper.select(null, null));
    }

    /**
     * 根据serviceId查询类别
     *
     * @param serviceId 服务id
     * @return 类别列表
     */
    @Override
    @Cacheable(value = "category", key = "methodName + #serviceId")
    public List<Category> findAllByServiceId(long serviceId) {
        return categoryMapper.select(String.valueOf(serviceId), "serviceId");
    }

    /**
     * 是否存在类别
     *
     * @param id 类别id
     * @return boolean
     */
    @Override
    public boolean exist(long id) {
        return findById(id).size() == 0;
    }

    /**
     * 根据id查询类别
     *
     * @param id 类别id
     * @return 类别列表
     */
    @Override
    @Cacheable(value = "category", key = "methodName + #id")
    public List<Category> findById(long id) {
        return categoryMapper.select("id", String.valueOf(id));
    }
}
