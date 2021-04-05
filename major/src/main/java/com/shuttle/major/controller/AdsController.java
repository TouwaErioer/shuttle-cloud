package com.shuttle.major.controller;

import com.shuttle.major.annotation.Admin;
import com.shuttle.major.annotation.LoginUser;
import com.shuttle.major.entity.Ads;
import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.service.AdsService;
import com.shuttle.major.utils.ReturnMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description: 广告相关路由
 * @author: DHY
 * @created: 2020/10/30 13:49
 */
@RestController
@RequestMapping("/poster")
public class AdsController {

    @Resource
    private AdsService adsService;

    @Admin
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Ads ads, int expired) {
        adsService.insert(ads, expired);
        return ReturnMessageUtil.sucess();
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        adsService.delete(id);
        return ReturnMessageUtil.sucess();
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Ads ads) {
        adsService.update(ads);
        return ReturnMessageUtil.sucess();
    }

    @LoginUser
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll() {
        return ReturnMessageUtil.sucess(adsService.findAll());
    }
}