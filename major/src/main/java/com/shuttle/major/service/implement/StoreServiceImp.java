package com.shuttle.major.service.implement;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shuttle.major.common.logger.LoggerHelper;
import com.shuttle.major.config.exception.BusinessException;
import com.shuttle.major.config.redis.RedisService;
import com.shuttle.major.entity.Orders;
import com.shuttle.major.entity.Store;
import com.shuttle.major.fetch.OrderFetch;
import com.shuttle.major.mapper.StoreMapper;
import com.shuttle.major.repository.elasticsearch.EsPageHelper;
import com.shuttle.major.repository.elasticsearch.StoreRepository;
import com.shuttle.major.service.CategoryService;
import com.shuttle.major.service.ProductService;
import com.shuttle.major.service.ServiceService;
import com.shuttle.major.service.StoreService;
import com.shuttle.major.utils.JwtUtils;
import com.shuttle.major.utils.Utils;
import lombok.extern.log4j.Log4j2;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @description: 商店服务实现类
 * @author: DHY
 * @created: 2021/02/03 19:48
 */

@Service
@Log4j2
public class StoreServiceImp implements StoreService {

    @Resource
    private StoreMapper storeMapper;

    @Resource
    private RedisService redisService;

    @Resource
    private ProductService productService;

    @Resource
    private StoreRepository storeRepository;

    @Resource
    private CategoryService categoryService;

    @Resource
    private ServiceService serviceService;

    @Resource
    private EsPageHelper<Store> esPageHelper;

    @Resource
    private OrderFetch orderFetch;

    /**
     * 添加商店
     *
     * @param store 商店
     */
    @Override
    @Transactional
    @CacheEvict(value = "store", allEntries = true)
    public void insert(Store store) {
        if (!categoryService.exist(store.getCategoryId()) || !serviceService.exist(store.getServiceId()))
            throw new BusinessException(0, "类别或服务id不存在");
        int res = storeMapper.insert(store);
        log.info(LoggerHelper.logger(store, res));
        BusinessException.check(res, "添加失败");
        storeRepository.save(store);
    }

    /**
     * 增加商店销量
     *
     * @param id       商店id
     * @param quantity 数量
     */
    @Override
    public void sales(long id, int quantity) {
        int res = storeMapper.sales(id, quantity);
        BusinessException.check(res, "增加商店销量失败");
        redisService.incrScore("store_rank", String.valueOf(id), quantity);
    }

    /**
     * 删除商店
     *
     * @param id 商店id
     */
    @Override
    @Transactional
    @CacheEvict(value = "store", allEntries = true)
    public void delete(long id) {
        int res = storeMapper.delete(id, "id");
        productService.deleteByStoreId(id);
        log.info(LoggerHelper.logger(id, res));
        BusinessException.check(res, "删除失败");
        storeRepository.deleteById(id);
    }

    /**
     * 根据类别id删除商店
     *
     * @param categoryId 类别id
     */
    @Override
    @Transactional
    @CacheEvict(value = "store", allEntries = true)
    public void deleteByCategoryId(long categoryId) {
        for (Store store : findByCategoryId(categoryId)) productService.deleteByStoreId(store.getId());
        int res = storeMapper.delete(categoryId, "categoryId");
        log.info(LoggerHelper.logger(categoryId, res));
    }

    /**
     * 更新商店评分
     *
     * @param id   商店id
     * @param rate 评分
     */
    @Override
    @CacheEvict(value = "store", allEntries = true)
    public void review(long id, float rate, String token) {
        long userId = JwtUtils.getUserId(token);
        List<Orders> list = (List<Orders>) orderFetch.findByCid(userId).getData();
        boolean status = false;
        for (Orders orders : list) {
            if (orders.getStoreId() == id) {
                status = true;
                break;
            }
        }
        if (!JwtUtils.is_admin(token) || !status) throw new BusinessException(1, "只允许管理员或在此商店消费过的用户可以评分");
        int res = storeMapper.review(id, rate);
        log.info(LoggerHelper.logger(id, res));
        BusinessException.check(res, "更新失败");
        Store store = findById(id).get(0);
        redisService.review(store.getRate(), store.getSales(), "store_rank", String.valueOf(id));
    }

    /**
     * 更新商店
     *
     * @param store 商店
     */
    @Override
    @Transactional
    @CacheEvict(value = "store", allEntries = true)
    public void update(Store store) {
        if (!categoryService.exist(store.getCategoryId()) || !serviceService.exist(store.getServiceId()))
            throw new BusinessException(0, "类别或服务id不存在");
        int res = storeMapper.update(store);
        log.info(LoggerHelper.logger(store, res));
        BusinessException.check(res, "更新失败");
        storeRepository.save(store);
    }

    /**
     * 批量根据商店id查询商店
     *
     * @param storeIds 商店id集合
     * @return 商店集合
     */
    @Override
    @Cacheable(value = "store", key = "methodName + #storeIds.toString()")
    public Map<Long, Store> batchQueryStore(List<Long> storeIds) {
        Map<String, Object> storeIdsParam = new HashMap<>();
        storeIdsParam.put("storeIds", storeIds);
        List<Store> storeList = storeMapper.batchQueryStore(storeIdsParam);
        Map<Long, Store> storeMap = new HashMap<>();
        for (Store store : storeList) {
            storeMap.put(store.getId(), store);
        }
        return storeMap;
    }

    /**
     * 查询全部商店
     *
     * @return 分页包装类
     */
    @Override
    @Cacheable(value = "store", key = "methodName + #option.toString()")
    public PageInfo<Store> findAll(Map<String, String> option) {
        Utils.checkOption(option, Store.class);
        String orderBy = String.format("store.%s %s", option.get("sort"), option.get("order"));
        PageHelper.startPage(Integer.parseInt(option.get("pageNo")), Integer.parseInt(option.get("pageSize")), orderBy);
        return PageInfo.of(storeMapper.select(null, null));
    }

    /**
     * 查询全部商店
     *
     * @return 分页包装类
     */
    @Cacheable(value = "store", key = "methodName")
    public List<Store> findAll() {
        return storeMapper.select(null, null);
    }

    /**
     * 根据serviceId查询商店
     *
     * @param serviceId 服务id
     * @return 商店列表
     */
    @Override
    @Cacheable(value = "store", key = "methodName + #serviceId + #option.toString()")
    public PageInfo<Store> findByServiceId(long serviceId, Map<String, String> option) {
        Utils.checkOption(option, Store.class);
        String orderBy = String.format("store.%s %s", option.get("sort"), option.get("order"));
        PageHelper.startPage(Integer.parseInt(option.get("pageNo")), Integer.parseInt(option.get("pageSize")), orderBy);
        return PageInfo.of(storeMapper.select(String.valueOf(serviceId), "serviceId"));
    }

    /**
     * 根据categoryId查询商店
     *
     * @param categoryId 类别id
     * @return 商店列表
     */
    @Override
    @Cacheable(value = "store", key = "methodName + #categoryId")
    public List<Store> findByCategoryId(long categoryId) {
        return storeMapper.select(String.valueOf(categoryId), "categoryId");
    }

    /**
     * 根据categoryId查询商店（分页）
     *
     * @param categoryId 类别id
     * @return 商店列表
     */
    @Override
    @Cacheable(value = "store", key = "methodName + #categoryId + #option.toString()")
    public PageInfo<Store> findByCategoryId(long categoryId, Map<String, String> option) {
        Utils.checkOption(option, Store.class);
        String orderBy = String.format("store.%s %s", option.get("sort"), option.get("order"));
        PageHelper.startPage(Integer.parseInt(option.get("pageNo")), Integer.parseInt(option.get("pageSize")), orderBy);
        return PageInfo.of(storeMapper.select(String.valueOf(categoryId), "categoryId"));
    }

    /**
     * 根据id查询商店
     *
     * @param id 商店id
     * @return 商店列表
     */
    @Override
    @Cacheable(value = "store", key = "methodName + #id")
    public List<Store> findById(long id) {
        return storeMapper.select(String.valueOf(id), "id");
    }

    /**
     * 排行榜
     *
     * @return 商店列表
     */
    @Override
    @Cacheable(value = "store", key = "methodName + #option.toString()")
    public List<Store> rank(Map<String, String> option) {
        Utils.checkQuantity(option);
        int quantity = Integer.parseInt(option.get("quantity"));
        Set<String> range = redisService.range("store_rank", 0, (quantity - 1));
        // 如果排行榜为空，将所有商店加入进去，分数为0
        if (range.size() == 0) {
            List<Store> stores = findAll();
            for (Store store : stores) {
                double score = Utils.changeRate(store.getRate(), store.getSales());
                redisService.incrScore("store_rank", String.valueOf(store.getId()), score);
            }
            range = redisService.range("store_rank", 0, (quantity - 1));
        }
        List<Store> stores = new ArrayList<>();
        for (String id : range) {
            stores.add(findById(Long.parseLong(id)).get(0));
        }
        return stores;
    }

    /**
     * 搜索
     *
     * @param keyword 关键词
     * @return 商店列表
     */
    @Override
    public SearchHits search(String keyword, Map<String, String> option) {
        return esPageHelper.build(QueryBuilders.matchQuery("name", keyword), option, Store.class);
    }

    /**
     * 是否存在商店
     *
     * @param id 商店id
     * @return boolean
     */
    @Override
    public boolean exist(long id) {
        return findById(id).size() != 0;
    }

    /**
     * 根据名字查询商店
     *
     * @param name 名字
     * @return 商店列表
     */
    @Override
    @Cacheable(value = "store", key = "methodName + #name")
    public List<Store> findByName(String name) {
        return storeMapper.findByName(name);
    }
}
