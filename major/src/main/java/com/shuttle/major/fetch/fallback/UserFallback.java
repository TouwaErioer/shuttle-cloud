package com.shuttle.major.fetch.fallback;

import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.fetch.ServiceFetch;
import com.shuttle.major.fetch.UserFetch;
import com.shuttle.major.utils.ReturnMessageUtil;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/26 14:59
 */
@Component
public class UserFallback implements UserFetch {

    @Override
    public ReturnMessage<Object> findById(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> sendEmail(String email, String content, String subject) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }
}