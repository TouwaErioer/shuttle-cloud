package com.shuttle.user;

import com.shuttle.user.config.rabbitMQ.sender.SendMessage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @description:
 * @author: DHY
 * @created: 2021/04/01 10:57
 */

@SpringBootTest
public class SenderTest {

    @Resource
    private SendMessage sendMessage;

    @Test
    public void test() throws InterruptedException {
        sendMessage.send("","confirm_test_queue","test");

        Thread.sleep(500);
    }
}
