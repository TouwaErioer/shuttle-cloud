package com.shuttle.feign.fallback;

import com.shuttle.feign.entity.Orders;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fetch.OrdersFetch;
import com.shuttle.feign.utils.ReturnMessageUtil;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/26 17:51
 */
@Component
public class OrdersFallback implements OrdersFetch {
    @Override
    public ReturnMessage<Object> insert(List<Orders> orderList, boolean isExpired) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> delete(List<Orders> orders, String token) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> update(Orders order) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> receive(long id, long userId) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> completed(Orders orders, String token) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findAll(Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findByPid(long pid, Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findByCid(long cid, Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findBySidOrCompleted(long sid, Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findBySidOrPresent(long sid, Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findById(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findByReceive(Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findByCompleted(Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findByPresent(Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> exist(long id) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }
}
