package com.shuttle.gateway.controller;

import com.shuttle.gateway.entity.ReturnMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public Object fallback() {
        return new ReturnMessage<Object>(-1, "系统错误", null);
    }
}