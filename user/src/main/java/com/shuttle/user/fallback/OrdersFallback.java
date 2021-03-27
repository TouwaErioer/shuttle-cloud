package com.shuttle.user.fallback;

import com.shuttle.user.entity.ReturnMessage;
import com.shuttle.user.fetch.OrdersFetch;
import com.shuttle.user.utils.ReturnMessageUtil;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/27 23:08
 */
@Component
public class OrdersFallback implements OrdersFetch {
    @Override
    public ReturnMessage<Object> deleteByUserId(long userId) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }
}