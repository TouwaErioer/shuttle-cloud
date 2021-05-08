package com.shuttle.major.fetch;

import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.fetch.fallback.UserFallback;
import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    ReturnMessage<Object> sendEmail(@Param("email") String email, @Param("content") String content, @Param("subject") String subject);
}