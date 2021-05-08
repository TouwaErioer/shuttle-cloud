package com.shuttle.major.controller;

import com.shuttle.major.annotation.Admin;
import com.shuttle.major.annotation.LoginUser;
import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.entity.Services;
import com.shuttle.major.service.ServiceService;
import com.shuttle.major.utils.ReturnMessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/29 15:25
 */
@RestController
@RequestMapping("/major/service")
public class ServiceController {
    
    @Resource
    private ServiceService serviceService;

    @Admin
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Services services) {
        serviceService.insert(services);
        return ReturnMessageUtil.success();
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        serviceService.delete(id);
        return ReturnMessageUtil.success();
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Services services) {
        serviceService.update(services);
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(serviceService.findAll(option));
    }

    @LoginUser
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findById(@PathVariable long id) {
        return ReturnMessageUtil.success(serviceService.findById(id));
    }

    @LoginUser
    @RequestMapping(value = "/exit/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> exit(@PathVariable long id) {
        return ReturnMessageUtil.success(serviceService.exist(id));
    }
}
