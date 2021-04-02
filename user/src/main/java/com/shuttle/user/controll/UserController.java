package com.shuttle.user.controll;

import com.shuttle.user.annotation.Admin;
import com.shuttle.user.annotation.LoginUser;
import com.shuttle.user.annotation.PassToken;
import com.shuttle.user.entity.ReturnMessage;
import com.shuttle.user.entity.User;
import com.shuttle.user.service.UserService;
import com.shuttle.user.utils.ReturnMessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
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
    private UserService userService;

    @PassToken
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ReturnMessage<Object> login(String account, String password, int expired) {
        return ReturnMessageUtil.success(userService.login(account, password, expired));
    }

    @LoginUser
    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ReturnMessage<Object> check() {
        return ReturnMessageUtil.success();
    }

    @PassToken
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ReturnMessage<Object> register(User user) {
        userService.register(user);
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public ReturnMessage<Object> resetPassword(long id, String password) {
        userService.updatePassword(id, password);
        return ReturnMessageUtil.success();
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        userService.delete(id);
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(User user) {
        userService.update(user);
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findById(@PathVariable("id") long id) {
        return ReturnMessageUtil.success(userService.findById(id).get(0));
    }

    @LoginUser
    @RequestMapping(value = "/batchQueryByUserId", method = RequestMethod.POST)
    public ReturnMessage<Object> batchQueryByUserId(@RequestParam List<Long> userIds){
        return ReturnMessageUtil.success(userService.batchQueryByUserId(userIds));
    }

    @Admin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(userService.findAll(option));
    }

    @Admin
    @RequestMapping(value = "/findByPhone/{phone}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByPhone(@PathVariable("phone") String phone) {
        return ReturnMessageUtil.success(userService.findByPhone(phone).get(0));
    }

    @LoginUser
    @RequestMapping(value = "/findSore/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findScore(@PathVariable("id") long id) {
        int score = userService.findByScore(id);
        return ReturnMessageUtil.success(score);
    }

    @Admin
    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
    public ReturnMessage<Object> search(@PathVariable("keyword") String keyword, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(userService.search(keyword, option));
    }

    @Admin
    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ReturnMessage<Object> admin(long userId) {
        userService.admin(userId);
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/reduceScore/{userId}", method = RequestMethod.GET)
    public ReturnMessage<Object> reduceScore(@PathVariable long userId,HttpServletRequest request) {
        userService.reduceScore(userId,request.getHeader("authorization"));
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/exist/{userId}", method = RequestMethod.GET)
    public ReturnMessage<Object> exist(@PathVariable long userId) {
        return ReturnMessageUtil.success(userService.exist(userId));
    }
}