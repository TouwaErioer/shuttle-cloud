package com.shuttle.feign.service.fallback;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.Services;
import com.shuttle.feign.service.feignService.ServiceFeign;
import com.shuttle.feign.utils.ReturnMessageUtil;

import java.util.Map;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/25 19:24
 */
public class ServiceFallbackFeign implements ServiceFeign {

    @Override
    public ReturnMessage<Object> insert(Services services) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> delete(Long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> update(Services services) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findAll(Map<String, String> option) {
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