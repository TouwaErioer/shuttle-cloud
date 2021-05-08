package com.shuttle.major.fetch;

import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.fetch.fallback.UserFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/26 14:53
 */

@FeignClient(value = "user", fallback = UserFallback.class)
public interface UserFetch {

    @GetMapping("/user/findById/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);

    @PostMapping("/email/send")
    ReturnMessage<Object> sendEmail(@RequestParam("email") String email, @RequestParam("content") String content, @RequestParam("subject") String subject);
}