package com.shuttle.feign.controll;

import com.shuttle.feign.entity.Ads;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fetch.AdsFetch;
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
    private AdsFetch adsFetch;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Ads ads, int expired) {
        return adsFetch.insert(ads, expired);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        return adsFetch.delete(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Ads ads) {
        return adsFetch.update(ads);
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll() {
        return adsFetch.findAll();
    }
}