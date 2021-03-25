package com.shuttle.feign.service;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.Services;

import java.util.Map;

public interface ServiceService {

    ReturnMessage<Object> insert(Services services);

    ReturnMessage<Object> delete(Long id);

    ReturnMessage<Object> update(Services services);

    ReturnMessage<Object> findAll(Map<String, String> option);

    ReturnMessage<Object> findById(long id);

    ReturnMessage<Object> exist(long id);
}