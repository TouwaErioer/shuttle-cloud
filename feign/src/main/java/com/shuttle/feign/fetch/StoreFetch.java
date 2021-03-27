package com.shuttle.feign.fetch;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.Store;
import com.shuttle.feign.fallback.StoreFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "major",fallback = StoreFallback.class)
public interface StoreFetch {

    @PostMapping("/store/insert")
    ReturnMessage<Object> insert(@RequestBody Store store);

    @DeleteMapping("/store/delete")
    ReturnMessage<Object> delete(long id);

    @PostMapping("/store/update")
    ReturnMessage<Object> update(@RequestBody Store store);

    @GetMapping("/store/rank")
    ReturnMessage<Object> rank();

    @GetMapping("/store/search/{keyword}")
    ReturnMessage<Object> search(@PathVariable String keyword, Map<String, String> option);

    @GetMapping("/store/findAll")
    ReturnMessage<Object> findAll(Map<String, String> option);

    @GetMapping("/store/findByServiceId/{serviceId}")
    ReturnMessage<Object> findByServiceId(@PathVariable long serviceId, Map<String, String> option);

    @GetMapping("/store/findByCategoryId/{categoryId}")
    ReturnMessage<Object> findByCategoryId(@PathVariable long categoryId);

    @GetMapping("/store/findById/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);

    @GetMapping("/store/exist/{id}")
    ReturnMessage<Object> exist(@PathVariable long id);
}
