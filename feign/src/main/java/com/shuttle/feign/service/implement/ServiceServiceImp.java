package com.shuttle.feign.service.implement;

import com.shuttle.feign.config.exception.BusinessException;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.Services;
import com.shuttle.feign.service.ServiceService;
import com.shuttle.feign.fetch.CategoryFetch;
import com.shuttle.feign.fetch.ServiceFetch;
import com.shuttle.feign.utils.ReturnMessageUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/25 17:07
 */
@Component
public class ServiceServiceImp implements ServiceService {

    @Resource
    private ServiceFetch serviceFetch;

    @Resource
    private CategoryFetch categoryFetch;

    @Override
    public ReturnMessage<Object> insert(Services services) {
        return serviceFetch.insert(services);
    }

    @Override
    public ReturnMessage<Object> delete(Long id) {
        BusinessException.check(categoryFetch.deleteByServiceId(id));
        BusinessException.check(serviceFetch.delete(id));
        return ReturnMessageUtil.success();
    }

    @Override
    public ReturnMessage<Object> update(Services services) {
        return serviceFetch.update(services);
    }

    @Override
    public ReturnMessage<Object> findAll(Map<String, String> option) {
        return serviceFetch.findAll(option);
    }

    @Override
    public ReturnMessage<Object> findById(long id) {
        return serviceFetch.findById(id);
    }

    @Override
    public ReturnMessage<Object> exist(long id) {
        return serviceFetch.exist(id);
    }
}