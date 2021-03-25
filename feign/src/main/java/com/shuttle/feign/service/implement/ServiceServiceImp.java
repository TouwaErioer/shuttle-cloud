package com.shuttle.feign.service.implement;

import com.shuttle.feign.config.exception.BusinessException;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.Services;
import com.shuttle.feign.service.ServiceService;
import com.shuttle.feign.service.feignService.CategoryFeign;
import com.shuttle.feign.service.feignService.ServiceFeign;
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
    private ServiceFeign serviceFeign;

    @Resource
    private CategoryFeign categoryFeign;

    @Override
    public ReturnMessage<Object> insert(Services services) {
        return serviceFeign.insert(services);
    }

    @Override
    public ReturnMessage<Object> delete(Long id) {
        BusinessException.check(categoryFeign.deleteByServiceId(id));
        BusinessException.check(serviceFeign.delete(id));
        return ReturnMessageUtil.success();
    }

    @Override
    public ReturnMessage<Object> update(Services services) {
        return serviceFeign.update(services);
    }

    @Override
    public ReturnMessage<Object> findAll(Map<String, String> option) {
        return serviceFeign.findAll(option);
    }

    @Override
    public ReturnMessage<Object> findById(long id) {
        return serviceFeign.findById(id);
    }

    @Override
    public ReturnMessage<Object> exist(long id) {
        return serviceFeign.exist(id);
    }
}