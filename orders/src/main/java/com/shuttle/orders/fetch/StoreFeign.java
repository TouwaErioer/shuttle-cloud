package com.shuttle.orders.fetch;

import com.shuttle.orders.entity.ReturnMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "major")
public interface StoreFeign {

    @GetMapping("/major/store/findById/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);

    @PostMapping("/major/store/batchQueryStoreId")
    ReturnMessage<Object> batchQueryByStoreId(@RequestParam List<Long> storeIds);
}