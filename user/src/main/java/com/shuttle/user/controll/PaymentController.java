package com.shuttle.user.controll;

import com.shuttle.user.service.PayService;
import com.shuttle.user.service.serviceImp.PayServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 支付相关路由
 * @author: DHY
 * @created: 2021/02/09 19:33
 */
@Controller
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PayService payService;


    @RequestMapping("/return")
    @ResponseBody
    public void returnCall(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String redirectUrl = payService.returnCall(request);
        response.sendRedirect(redirectUrl);
    }

    @RequestMapping("/notify")
    @ResponseBody
    public void notifyCall(HttpServletRequest request) throws Exception {
        payService.notifyCall(request);
    }
}