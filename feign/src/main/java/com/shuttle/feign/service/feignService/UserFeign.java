package com.shuttle.feign.service.feignService;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.User;
import com.shuttle.feign.service.fallback.UserFallbackFeign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(value = "user",fallback = UserFallbackFeign.class)
public interface UserFeign {

    @PostMapping("/user/register")
    ReturnMessage<Object> register(@RequestBody User user);

    @PostMapping("/user/login")
    ReturnMessage<Object> login(@RequestParam(value = "account") String account, @RequestParam(value = "password") String password, @RequestParam(value = "expired") int expired);

    @DeleteMapping("/user/delete")
    ReturnMessage<Object> delete(long id);

    @PostMapping("/user/update")
    ReturnMessage<Object> update(User user);

    @PostMapping("/user/updatePassword")
    ReturnMessage<Object> updatePassword(@RequestParam(value = "id") long id, @RequestParam(value = "password") String password);

    @PostMapping("/user/addScore")
    ReturnMessage<Object> addScore(@RequestParam(value = "id") long id, @RequestParam(value = "quantity") int quantity);

    @GetMapping("/user/reduceScore/{userId}")
    ReturnMessage<Object> reduceScore(@PathVariable long userId);

    @GetMapping("/user/findByScore/{id}")
    ReturnMessage<Object> findByScore(@PathVariable long id);

    @GetMapping("/user/findByPhone/{phone}")
    ReturnMessage<Object> findByPhone(@PathVariable String phone);

    @GetMapping("/user/findById/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);

    @GetMapping("/user/findAll")
    ReturnMessage<Object> findAll(Map<String, String> option);

    @GetMapping("/user/search")
    ReturnMessage<Object> search(@PathVariable String keyword, @RequestParam(value = "option") Map<String, String> option);

    @PostMapping("/user/admin")
    ReturnMessage<Object> admin(@RequestParam(value = "userId") long userId);

    @GetMapping("/user/exist/{userId}")
    ReturnMessage<Object> exist(@PathVariable long userId);
}