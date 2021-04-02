package com.shuttle.user.config.rabbitMQ.callback;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: DHY
 * @created: 2021/04/01 10:42
 */

@Component
@Log4j2
public class ReturnCallbackService implements RabbitTemplate.ReturnsCallback {

    /**
     * 消息未能投递到目标 queue
     *
     * @param returnedMessage 返回的消息
     */
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.info("returnedMessage ===> replyCode={} ,replyText={} ,exchange={} ,routingKey={}",
                returnedMessage.getReplyCode(),
                returnedMessage.getRoutingKey(),
                returnedMessage.getExchange(),
                returnedMessage.getRoutingKey());
    }
}
