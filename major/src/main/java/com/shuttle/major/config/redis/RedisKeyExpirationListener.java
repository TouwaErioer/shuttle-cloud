package com.shuttle.major.config.redis;

import com.shuttle.major.config.exception.BusinessException;
import com.shuttle.major.fetch.OrderFetch;
import com.shuttle.major.service.AdsService;
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
    private AdsService adsService;

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
        if (key.contains("ads")) adsService.delete(id);
    }
}