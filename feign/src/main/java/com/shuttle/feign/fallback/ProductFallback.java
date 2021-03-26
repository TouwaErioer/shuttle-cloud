package com.shuttle.feign.fallback;

import com.shuttle.feign.entity.Product;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fetch.ProductFetch;
import com.shuttle.feign.utils.ReturnMessageUtil;

import java.util.Map;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/26 15:53
 */
public class ProductFallback implements ProductFetch {
    @Override
    public ReturnMessage<Object> insert(Product product) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> delete(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> update(Product product) {
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
    public ReturnMessage<Object> findByStoreId(long storeId) {
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

    @Override
    public ReturnMessage<Object> review(Product product, String token) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }
}