package com.shuttle.feign.fetch;

import com.shuttle.feign.entity.Category;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fallback.CategoryFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "major", fallback = CategoryFallback.class)
public interface CategoryFetch {

    @PostMapping("/category/insert")
    ReturnMessage<Object> insert(@RequestBody Category category);

    @DeleteMapping("/category/delete")
    ReturnMessage<Object> delete(long id);

    @PostMapping("/category/update")
    ReturnMessage<Object> update(@RequestBody Category category);

    @GetMapping("/category/findAll")
    ReturnMessage<Object> findAll(Map<String, String> option);

    @GetMapping("/category/findAllByServiceId/{serviceId}")
    ReturnMessage<Object> findAllByServiceId(@PathVariable long serviceId);

    @GetMapping("/category/exist/{id}")
    ReturnMessage<Object> exist(@PathVariable long id);

    @GetMapping("/category/findById/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);

    @DeleteMapping("/category/{serviceId}")
    ReturnMessage<Object> deleteByServiceId(@PathVariable long serviceId);
}