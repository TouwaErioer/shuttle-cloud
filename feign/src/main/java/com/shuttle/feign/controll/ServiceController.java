package com.shuttle.feign.controll;

import com.shuttle.feign.annotation.Admin;
import com.shuttle.feign.annotation.LoginUser;
import com.shuttle.feign.config.exception.BusinessException;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.Services;
import com.shuttle.feign.fetch.CategoryFetch;
import com.shuttle.feign.fetch.ServiceFetch;
import com.shuttle.feign.utils.ReturnMessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


@RestController
@RequestMapping("/service")
public class ServiceController {

    @Resource
    private ServiceFetch serviceFetch;

    @Resource
    private CategoryFetch categoryFetch;

    @Admin
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Services services) {
        return serviceFetch.insert(services);
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        BusinessException.check(categoryFetch.deleteByServiceId(id));
        BusinessException.check(serviceFetch.delete(id));
        return ReturnMessageUtil.success();
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Services services) {
        return serviceFetch.update(services);
    }

    @LoginUser
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(serviceFetch.findAll(option));
    }

    @LoginUser
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findById(@PathVariable long id) {
        return ReturnMessageUtil.success(serviceFetch.findById(id));
    }

    @LoginUser
    @RequestMapping(value = "/exist/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> exist(@PathVariable long id) {
        return ReturnMessageUtil.success(serviceFetch.exist(id));
    }
}