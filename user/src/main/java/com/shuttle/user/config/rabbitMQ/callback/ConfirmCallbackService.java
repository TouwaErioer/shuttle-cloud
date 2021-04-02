package com.shuttle.user.config.rabbitMQ.callback;

import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: DHY
 * @created: 2021/04/01 10:37
 */
@Component
@Log4j2
public class ConfirmCallbackService implements RabbitTemplate.ConfirmCallback {
    /**
     * 消息是否被 broker 接收
     *
     * @param correlationData 对象内部只有一个 id 属性，用来表示当前消息的唯一性
     * @param ack             消息投递到broker的状态
     * @param cause           表示投递失败的原因
     */
    @Override
    public void confirm(CorrelationData correlationData, boolean ack, String cause) {
        log.info("correlationData={} ,ack={}, cause={}", correlationData.getId(), ack, cause);
    }
}