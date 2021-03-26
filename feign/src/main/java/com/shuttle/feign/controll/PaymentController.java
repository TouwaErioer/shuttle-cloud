package com.shuttle.feign.controll;

import com.shuttle.feign.fetch.UserFetch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public void returnCall(HttpServletRequest request, HttpServletResponse response) {
        userFetch.returnCall(request, response);
    }

    @RequestMapping("/notify")
    @ResponseBody
    public void notifyCall(HttpServletRequest request) {
        userFetch.notifyCall(request);
    }
}