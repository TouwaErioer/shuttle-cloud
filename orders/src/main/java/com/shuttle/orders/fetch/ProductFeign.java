package com.shuttle.orders.fetch;

import com.shuttle.orders.entity.ReturnMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "major")
public interface ProductFeign {

    @GetMapping("/major/product/exist/{id}")
    ReturnMessage<Object> exist(@PathVariable long id);

    @PostMapping("/major/product/addSales")
    ReturnMessage<Object> addSales(@RequestParam("id") long id, @RequestParam("sales") int sales);

    @GetMapping("/major/product/findById/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);

    @PostMapping("/major/product/batchQueryProductId")
    ReturnMessage<Map> batchQueryByProductId(@RequestParam List<Long> productIds);
}