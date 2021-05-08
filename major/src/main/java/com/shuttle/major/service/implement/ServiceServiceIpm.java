package com.shuttle.major.service.implement;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shuttle.major.common.logger.LoggerHelper;
import com.shuttle.major.config.exception.BusinessException;
import com.shuttle.major.entity.Services;
import com.shuttle.major.mapper.ServiceMapper;
import com.shuttle.major.service.CategoryService;
import com.shuttle.major.service.ServiceService;
import com.shuttle.major.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
public class ServiceServiceIpm implements ServiceService {

    @Resource
    private ServiceMapper serviceMapper;

    @Resource
    private CategoryService categoryService;

    /**
     * 添加服务
     *
     * @param services 服务
     */
    @Override
    @Transactional
    @CacheEvict(value = "service", allEntries = true)
    public void insert(Services services) {
        int res = serviceMapper.insert(services);
        log.info(LoggerHelper.logger(services, res));
        BusinessException.check(res, "添加失败");
    }

    /**
     * 删除服务
     *
     * @param id 服务id
     */
    @Override
    @Transactional
    @CacheEvict(value = "service", allEntries = true)
    public void delete(Long id) {
        int res = serviceMapper.delete(id);
        log.info(LoggerHelper.logger(id, res));
        BusinessException.check(res, "服务删除失败");
        categoryService.deleteByServiceId(id);
    }

    /**
     * 修改服务
     *
     * @param services 服务
     */
    @Override
    @Transactional
    @CacheEvict(value = "service", allEntries = true)
    public void update(Services services) {
        int res = serviceMapper.update(services);
        log.info(LoggerHelper.logger(services, res));
        BusinessException.check(res, "修改失败");
    }

    /**
     * 查询全部服务
     *
     * @return 分页包装类
     */
    @Override
    @Cacheable(value = "service", key = "methodName + #option.toString()")
    public PageInfo<Services> findAll(Map<String, String> option) {
        Utils.checkOption(option, Services.class);
        String orderBy = String.format("%s %s", option.get("sort"), option.get("order"));
        PageHelper.startPage(Integer.parseInt(option.get("pageNo")), Integer.parseInt(option.get("pageSize")), orderBy);
        return PageInfo.of(serviceMapper.findAll());
    }

    /**
     * 是否存在服务
     *
     * @param id 服务id
     * @return boolean
     */
    @Override
    public boolean exist(long id) {
        return findById(id).size() != 0;
    }

    /**
     * 根据服务id查询服务
     *
     * @param id 服务id
     * @return 服务列表
     */
    @Override
    @Cacheable(value = "service", key = "methodName + #id")
    public List<Services> findById(long id) {
        return serviceMapper.findById(id);
    }
}