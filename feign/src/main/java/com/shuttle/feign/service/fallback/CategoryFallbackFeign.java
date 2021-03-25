package com.shuttle.feign.service.fallback;

import com.shuttle.feign.entity.Category;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.service.feignService.CategoryFeign;
import com.shuttle.feign.utils.ReturnMessageUtil;

import java.util.Map;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/25 19:30
 */
public class CategoryFallbackFeign implements CategoryFeign {
    @Override
    public ReturnMessage<Object> insert(Category category) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> delete(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> update(Category category) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findAll(Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findAllByServiceId(long serviceId) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> exist(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findById(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> deleteByServiceId(long serviceId) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }
}