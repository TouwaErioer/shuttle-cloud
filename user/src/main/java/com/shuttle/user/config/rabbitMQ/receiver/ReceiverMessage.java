package com.shuttle.user.config.rabbitMQ.receiver;

import com.rabbitmq.client.Channel;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @description:
 * @author: DHY
 * @created: 2021/04/01 10:53
 */
@Component
@Log4j2
@RabbitListener(queues = "confirm_test_queue")
public class ReceiverMessage {


    @RabbitHandler
    public void processHandler1(String msg, Channel channel, Message message) throws IOException {

        try {
            log.info("消费者收到：{}", msg);

            // 具体业务

            // 表示成功确认，使用此回执方法后，消息会被rabbitmq broker 删除
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);

        }  catch (Exception e) {

            if (message.getMessageProperties().getRedelivered()) {

                log.error("消息已重复处理失败,拒绝再次接收...");

                // 拒绝消息，与basicNack区别在于不能进行批量操作，其他用法很相似
                channel.basicReject(message.getMessageProperties().getDeliveryTag(), false); // 拒绝消息
            } else {

                log.error("消息即将再次返回队列处理...");

                // 表示失败确认，一般在消费消息业务异常时用到此方法，可以将消息重新投递入队列
                channel.basicNack(message.getMessageProperties().getDeliveryTag(), false, true);
            }
        }
    }
}
