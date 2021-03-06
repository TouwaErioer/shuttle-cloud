package com.shuttle.major.fetch.fallback;

import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.fetch.OrderFetch;
import com.shuttle.major.utils.ReturnMessageUtil;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/26 14:58
 */
@Component
public class OrderFetchFallback implements OrderFetch {

    @Override
    public ReturnMessage<Object> deleteByPid(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findByCid(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> delete(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> completed(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findById(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }
}