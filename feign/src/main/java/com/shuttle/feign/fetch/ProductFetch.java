package com.shuttle.feign.fetch;

import com.shuttle.feign.entity.Product;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fallback.ProductFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "major", fallback = ProductFallback.class)
public interface ProductFetch {

    @PostMapping("/product/insert")
    ReturnMessage<Object> insert(@RequestBody Product product);

    @DeleteMapping("/product/delete")
    ReturnMessage<Object> delete(long id);

    @PostMapping("/product/update")
    ReturnMessage<Object> update(Product product);

    @GetMapping("/product/rank")
    ReturnMessage<Object> rank();

    @GetMapping("/product/search/{keyword}")
    ReturnMessage<Object> search(@PathVariable String keyword, Map<String, String> option);

    @RequestMapping(value = "/product/findAll", method = RequestMethod.GET)
    ReturnMessage<Object> findAll(@RequestParam(value = "option", required = false) Map<String, String> option);

    @GetMapping("/product/findByStoreId/{storeId}")
    ReturnMessage<Object> findByStoreId(@PathVariable long storeId);

    @GetMapping("/product/rank/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);

    @GetMapping("/product/exist/{id}")
    ReturnMessage<Object> exist(@PathVariable long id);

    @PostMapping("/product/review")
    ReturnMessage<Object> review(@RequestBody Product product, @RequestParam("token") String token);
}