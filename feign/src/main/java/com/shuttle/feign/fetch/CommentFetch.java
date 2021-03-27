package com.shuttle.feign.fetch;

import com.shuttle.feign.entity.Comments;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fallback.CommentFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "major", fallback = CommentFallback.class)
public interface CommentFetch {

    @PostMapping("/comments/insert")
    ReturnMessage<Object> insert(@RequestParam("token") String token, @RequestBody Comments comments);

    @DeleteMapping("/comments/delete")
    ReturnMessage<Object> delete(@RequestBody Comments comments, @RequestParam("token") String token);

    @PostMapping("/comments/update")
    ReturnMessage<Object> update(@RequestBody Comments comments, @RequestParam("token") String token);

    @GetMapping("/comments/findByStoreId/{storeId}")
    ReturnMessage<Object> findByStoreId(@PathVariable long storeId, Map<String, String> option);

    @GetMapping("/comments/findAll")
    ReturnMessage<Object> findAll(Map<String, String> option);
}
