package com.shuttle.user.controll;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/28 17:00
 */

@RestController
@RequestMapping("/config")
public class ConfigController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/getPort",method = RequestMethod.GET)
    public String getPort(){
        return port;
    }
}