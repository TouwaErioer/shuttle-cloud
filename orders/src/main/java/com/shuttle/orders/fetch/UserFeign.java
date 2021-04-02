package com.shuttle.orders.fetch;

import com.shuttle.orders.entity.ReturnMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "user")
public interface UserFeign {

    @GetMapping("/user/exist/{id}")
    ReturnMessage<Object> exist(@PathVariable long id);

    @GetMapping("/user/reduceScore/{userId}")
    ReturnMessage<Object> reduceScore(@PathVariable long userId);

    @GetMapping("/user/findById/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);

    @PostMapping("/user/batchQueryByUserId")
    ReturnMessage<Object> batchQueryByUserId(@RequestParam List<Long> userIds);
}