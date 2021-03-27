package com.shuttle.orders.config.redis;

import com.shuttle.orders.service.OrderService;
import com.shuttle.orders.service.implement.OrderServiceIpm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @description:
 * @author: DHY
 * @created: 2020/11/14 20:48
 */
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {

    @Resource
    private OrderServiceIpm orderServiceIpm;

    @Autowired
    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     * 使用该方法监听 ,当key失效的时候执行该方法
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        String key = message.toString();
        long id = Long.parseLong(key.substring(key.indexOf("_") + 1));
        if (key.contains("order")) orderServiceIpm.delete(id);
        else if (key.contains("completed")) orderServiceIpm.completed(id);
    }
}