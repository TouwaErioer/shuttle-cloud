package com.shuttle.major.config.interceptor;

import com.shuttle.major.annotation.Admin;
import com.shuttle.major.annotation.LoginUser;
import com.shuttle.major.annotation.PassToken;
import com.shuttle.major.config.exception.BusinessException;
import com.shuttle.major.utils.JwtUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class Authentication implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String token = request.getHeader("authorization");

        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) return true;

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(PassToken.class)) return true;

        if (token == null) throw new BusinessException(0, "无token,请重新登陆");


        if (method.isAnnotationPresent(LoginUser.class)) {
            JwtUtils.parseJWT(token);
            return true;
        }

        if (method.isAnnotationPresent(Admin.class)) {
            if (!JwtUtils.is_admin(token)) throw new BusinessException(0, "权限不够");
            JwtUtils.parseJWT(token);
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}