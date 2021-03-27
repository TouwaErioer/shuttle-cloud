package com.shuttle.feign.fetch;

import com.shuttle.feign.entity.Ads;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fallback.AdsFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "major-service", fallback = AdsFallback.class)
public interface AdsFetch {

    @PostMapping("/poster/insert")
    ReturnMessage<Object> insert(@RequestBody Ads ads, @RequestParam("expired") int expired);

    @DeleteMapping("/poster/delete")
    ReturnMessage<Object> delete(long id);

    @PostMapping("/poster/update")
    ReturnMessage<Object> update(@RequestBody Ads ads);

    @GetMapping("/poster/findAll")
    ReturnMessage<Object> findAll();
}