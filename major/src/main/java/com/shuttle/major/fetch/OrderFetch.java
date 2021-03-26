package com.shuttle.major.fetch;

import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.fetch.fallback.OrderFetchFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "order", fallback = OrderFetchFallback.class)
public interface OrderFetch {

    @DeleteMapping("/order/deleteByPid")
    ReturnMessage<Object> deleteByPid(long id);

    @GetMapping("/order/findByCid/{id}")
    ReturnMessage<Object> findByCid(@PathVariable long id);
}