package com.shuttle.feign.fallback;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.Store;
import com.shuttle.feign.fetch.StoreFetch;
import com.shuttle.feign.utils.ReturnMessageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/26 15:53
 */
@Component
public class StoreFallback implements StoreFetch {
    @Override
    public ReturnMessage<Object> insert(Store store) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> delete(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> update(Store store) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> rank() {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> search(String keyword, Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findAll(Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findByServiceId(long serviceId, Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findByCategoryId(long categoryId) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findById(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> exist(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }
}
