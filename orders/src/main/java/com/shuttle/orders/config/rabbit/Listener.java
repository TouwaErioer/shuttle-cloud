package com.shuttle.orders.config.rabbit;

import cn.hutool.json.JSONUtil;
import com.shuttle.orders.entity.Orders;
import com.shuttle.orders.service.WebSocketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class Listener {

    @Resource
    private WebSocketService webSocketService;

    // 收消息
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order.created", durable = "true"),
            exchange = @Exchange(
                    value = "order.exchange",
                    ignoreDeclarationExceptions = "true", // 忽略声明异常
                    type = ExchangeTypes.TOPIC // 交换机类型
            ),
            key = "order.created"
    ))
    public void onOrderCreated(Orders order) {
        log.info("create order ->:{}", order.getId());
        webSocketService.sendMessage(JSONUtil.toJsonStr(order));
    }
}
