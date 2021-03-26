package com.shuttle.feign.fetch;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.Services;
import com.shuttle.feign.fallback.ServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "service", fallback = ServiceFallback.class)
public interface ServiceFetch {

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