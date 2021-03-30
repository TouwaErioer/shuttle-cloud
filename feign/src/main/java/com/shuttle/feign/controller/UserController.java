package com.shuttle.feign.controller;

import com.shuttle.feign.annotation.Admin;
import com.shuttle.feign.annotation.LoginUser;
import com.shuttle.feign.annotation.PassToken;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.User;
import com.shuttle.feign.fetch.UserFetch;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description: 用户相关路由
 * @author: DHY
 * @created: 2020/10/23 20:11
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserFetch userFetch;

    @PassToken
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ReturnMessage<Object> login(String account, String password, int expired) {
        return userFetch.login(account, password, expired);// todo 前端改account
    }

    @LoginUser
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public boolean check() {
        return true;
    }

    @PassToken
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ReturnMessage<Object> register(User user) {
        return userFetch.register(user);
    }

    @LoginUser
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public ReturnMessage<Object> resetPassword(long id, String password) {
        return userFetch.updatePassword(id, password);
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> login(long id) {
        return userFetch.delete(id);
    }

    @LoginUser
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(User user) {
        return userFetch.update(user);
    }

    @Admin
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findById(@PathVariable("id") long id) {
        return userFetch.findById(id);
    }

    @Admin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return userFetch.findAll(option);
    }

    @Admin
    @RequestMapping(value = "/findByPhone/{phone}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByPhone(@PathVariable("phone") String phone) {
        return userFetch.findByPhone(phone);
    }

    @LoginUser
    @RequestMapping(value = "/findSore/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findScore(@PathVariable("id") long id) {
        return userFetch.findByScore(id);
    }

//    /**
//     * showdoc
//     * @catalog 用户
//     * @title 充值
//     * @description 充值的接口
//     * @method post
//     * @url /user/recharge
//     * @param userId 必选 long 用户id
//     * @param total 必选 int 充值的数量
//     * @remark 跳转到支付宝支付界面
//     */
//    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
//    public String recharge(long userId, int total) throws AlipayApiException {
//        return payService.alipay(userId, total);
//    }

    @Admin
    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
    public ReturnMessage<Object> search(@PathVariable("keyword") String keyword, @RequestParam Map<String, String> option) {
        return userFetch.search(keyword, option);
    }

    @Admin
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ReturnMessage<Object> admin(long userId) {
        return userFetch.admin(userId);
    }
}