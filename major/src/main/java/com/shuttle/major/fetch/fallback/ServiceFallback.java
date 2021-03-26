package com.shuttle.major.fetch.fallback;

import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.fetch.ServiceFetch;
import com.shuttle.major.utils.ReturnMessageUtil;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/26 14:59
 */
public class ServiceFallback implements ServiceFetch {
    @Override
    public ReturnMessage<Object> exist(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }
}
