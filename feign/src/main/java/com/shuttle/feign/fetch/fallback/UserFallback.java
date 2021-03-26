package com.shuttle.feign.fetch.fallback;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.User;
import com.shuttle.feign.fetch.UserFetch;
import com.shuttle.feign.utils.ReturnMessageUtil;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @description: 用户服务降级
 * @author: DHY
 * @created: 2021/03/22 15:19
 */

@Component
public class UserFallback implements UserFetch {
    @Override
    public ReturnMessage<Object> register(User user) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> login(String account, String password, int expired) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> delete(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> update(User user) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> updatePassword(long id, String password) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> addScore(long id, int quantity) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> reduceScore(long userId) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findByScore(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findByPhone(String phone) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findById(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findAll(Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> search(String keyword, Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> admin(long userId) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> exist(long userId) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public void returnCall(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    public void notifyCall(HttpServletRequest request) {

    }
}
