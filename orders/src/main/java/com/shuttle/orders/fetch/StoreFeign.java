package com.shuttle.orders.fetch;

import com.shuttle.orders.entity.ReturnMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "major")
public interface StoreFeign {

    @GetMapping("/store/findById/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);
}