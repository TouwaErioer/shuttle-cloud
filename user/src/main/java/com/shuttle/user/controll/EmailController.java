package com.shuttle.user.controll;

import com.shuttle.user.entity.ReturnMessage;
import com.shuttle.user.service.MailService;
import com.shuttle.user.utils.ReturnMessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @description: 用户相关路由
 * @author: DHY
 * @created: 2020/10/23 20:11
 */

@RestController
@RequestMapping("/email")
public class EmailController {

    @Resource
    private MailService mailService;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public ReturnMessage<Object> send(String email, String content, String subject) {
        mailService.sendTokenMail(email, content, subject);
        return ReturnMessageUtil.success();
    }
}