package com.shuttle.user.fetch;

import com.shuttle.user.entity.ReturnMessage;
import com.shuttle.user.fallback.CommentFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "major", fallback = CommentFallback.class)
public interface CommentFetch {

    @DeleteMapping("/comments/updateByUserId")
    ReturnMessage<Object> updateByUserId(@RequestParam("userId") long userId, @RequestParam("userName") String userName);

}