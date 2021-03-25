package com.shuttle.feign.service.feignService;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.Services;
import com.shuttle.feign.service.fallback.ServiceFallbackFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "service", fallback = ServiceFallbackFeign.class)
public interface ServiceFeign {

    @PostMapping(value = "/service/insert")
    ReturnMessage<Object> insert(@RequestBody Services services);

    @DeleteMapping(value = "/service/delete")
    ReturnMessage<Object> delete(@RequestParam("id") Long id);

    @PostMapping(value = "/service/update")
    ReturnMessage<Object> update(@RequestBody Services services);

    @GetMapping(value = "/service/findAll")
    ReturnMessage<Object> findAll(Map<String, String> option);

    @GetMapping(value = "/service/findById/{id}")
    ReturnMessage<Object> findById(@PathVariable("id") long id);

    @GetMapping(value = "/service/exist/{id}")
    ReturnMessage<Object> exist(@PathVariable("id") long id);
}