package com.shuttle.feign.controller;

import com.shuttle.feign.fetch.UserFetch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/26 15:18
 */
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private UserFetch userFetch;

    @RequestMapping("/return")
    @ResponseBody
    public void returnCall() {
        userFetch.returnCall();
    }

    @RequestMapping("/notify")
    @ResponseBody
    public void notifyCall() {
        userFetch.notifyCall();
    }
}