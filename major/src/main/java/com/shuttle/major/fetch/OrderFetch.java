package com.shuttle.major.fetch;

import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.fetch.fallback.OrderFetchFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "order", fallback = OrderFetchFallback.class)
public interface OrderFetch {

    @DeleteMapping("/order/deleteByPid")
    ReturnMessage<Object> deleteByPid(long id);

    @GetMapping("/order/findByCid/{id}")
    ReturnMessage<Object> findByCid(@PathVariable long id);

    @DeleteMapping("/order/delete")
    ReturnMessage<Object> delete(long id);

    @PostMapping("/order/completed")
    ReturnMessage<Object> completed(@RequestParam("id") long id);

    @GetMapping("/order/findById/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);

}