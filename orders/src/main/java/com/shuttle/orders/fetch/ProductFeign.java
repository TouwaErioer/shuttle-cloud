package com.shuttle.orders.fetch;

import com.shuttle.orders.entity.ReturnMessage;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("major")
public interface ProductFeign {

    @GetMapping("/product/exist/{id}")
    ReturnMessage<Object> exist(@PathVariable long id);

    @PostMapping("/product/addSales")
    ReturnMessage<Object> addSales(@RequestParam("id") long id, @RequestParam("sales") int sales);

    @GetMapping("/product/rank/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);
}
