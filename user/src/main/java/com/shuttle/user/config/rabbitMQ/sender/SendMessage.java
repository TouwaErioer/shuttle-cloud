package com.shuttle.user.config.rabbitMQ.sender;

import com.shuttle.user.config.rabbitMQ.callback.ConfirmCallbackService;
import com.shuttle.user.config.rabbitMQ.callback.ReturnCallbackService;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @description:
 * @author: DHY
 * @created: 2021/04/01 10:48
 */
@Component
@Log4j2
public class SendMessage {

    @Resource
    private RabbitTemplate rabbitTemplate;

    @Resource
    private ConfirmCallbackService confirmCallbackService;

    @Resource
    private ReturnCallbackService returnCallbackService;

    /**
     * @param exchange   交换机
     * @param routingKey 队列
     * @param msg        消息体
     */
    public void send(String exchange, String routingKey, Object msg) {

        // 消息持久化处理，确保消息发送失败后可以重新返回到队列中
        rabbitTemplate.setMandatory(true);

        // 消费者确认收到消息后，手动ack回执回调处理
        rabbitTemplate.setConfirmCallback(confirmCallbackService);

        // 消息投递到队列失败回调处理
        rabbitTemplate.setReturnsCallback(returnCallbackService);

        // 发送消息
        rabbitTemplate.convertAndSend(exchange, routingKey, msg,
                message -> {
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.PERSISTENT);
                    return message;
                },
                new CorrelationData(UUID.randomUUID().toString()));
    }
}
