package com.shuttle.user.controll;

import com.shuttle.user.entity.ReturnMessage;
import com.shuttle.user.entity.User;
import com.shuttle.user.service.UserService;
import com.shuttle.user.utils.ReturnMessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ReturnMessage<Object> login(String account, String password, int expired) {
        return ReturnMessageUtil.success(userService.login(account, password, expired));
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    public ReturnMessage<Object> check() {
        return ReturnMessageUtil.success();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ReturnMessage<Object> register(User user) {
        userService.register(user);
        return ReturnMessageUtil.success();
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public ReturnMessage<Object> resetPassword(long id, String password) {
        userService.updatePassword(id, password);
        return ReturnMessageUtil.success();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> login(long id) {
        userService.delete(id);
        return ReturnMessageUtil.success();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(User user) {
        userService.update(user);
        return ReturnMessageUtil.success();
    }

    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findById(@PathVariable("id") long id) {
        return ReturnMessageUtil.success(userService.findById(id).get(0));
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(userService.findAll(option));
    }

    @RequestMapping(value = "/findByPhone/{phone}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByPhone(@PathVariable("phone") String phone) {
        return ReturnMessageUtil.success(userService.findByPhone(phone).get(0));
    }

    @RequestMapping(value = "/findSore/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findScore(@PathVariable("id") long id) {
        int score = userService.findByScore(id);
        return ReturnMessageUtil.success(score);
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

    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
    public ReturnMessage<Object> search(@PathVariable("keyword") String keyword, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(userService.search(keyword, option));
    }

    @RequestMapping(value = "/admin", method = RequestMethod.POST)
    public ReturnMessage<Object> admin(long userId) {
        userService.admin(userId);
        return ReturnMessageUtil.success();
    }

    @RequestMapping(value = "/addScore", method = RequestMethod.POST)
    public ReturnMessage<Object> addScore(long id, int quantity) {
        userService.addScore(id,quantity);
        return ReturnMessageUtil.success();
    }

    @RequestMapping(value = "/reduceScore/{userId}", method = RequestMethod.GET)
    public ReturnMessage<Object> reduceScore(@PathVariable long userId) {
        userService.reduceScore(userId);
        return ReturnMessageUtil.success();
    }

    @RequestMapping(value = "/exist/{userId}", method = RequestMethod.GET)
    public ReturnMessage<Object> addScore(@PathVariable long userId) {
        return ReturnMessageUtil.success(userService.exist(userId));
    }
}