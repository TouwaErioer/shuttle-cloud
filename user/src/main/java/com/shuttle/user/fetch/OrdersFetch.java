package com.shuttle.user.fetch;

import com.shuttle.user.entity.ReturnMessage;
import com.shuttle.user.fallback.OrdersFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;

@FeignClient(value = "orders",fallback = OrdersFallback.class)
public interface OrdersFetch {

    @DeleteMapping("/orders/deleteByUserId")
    ReturnMessage<Object> deleteByUserId(long userId);
}