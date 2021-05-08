package com.shuttle.major.controller;

import com.shuttle.major.annotation.Admin;
import com.shuttle.major.annotation.LoginUser;
import com.shuttle.major.entity.ApproveProduct;
import com.shuttle.major.entity.ApproveStore;
import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.service.ApproveService;
import com.shuttle.major.utils.ReturnMessageUtil;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description: 审批相关路由
 * @author: DHY
 * @created: 2021/05/02 16:43
 */

@RestController
@RequestMapping(value = "/major/approve")
public class ApproveController {

    @Resource
    private ApproveService approveService;

    @LoginUser
    @RequestMapping(value = "/insertStore", method = RequestMethod.POST)
    public ReturnMessage<Object> insertStore(ApproveStore approveStore, HttpServletRequest request) {
        approveService.insertStore(approveStore, request.getHeader("Authorization"));
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/insertProduct", method = RequestMethod.POST)
    public ReturnMessage<Object> insertProduct(ApproveProduct approveProduct, HttpServletRequest request) {
        approveService.insertProduct(approveProduct, request.getHeader("Authorization"));
        return ReturnMessageUtil.success();
    }

    @Admin
    @RequestMapping(value = "/approveStore", method = RequestMethod.POST)
    public ReturnMessage<Object> approveStore(ApproveStore approveStore) {
        approveService.approveStore(approveStore);
        return ReturnMessageUtil.success();
    }

    @Admin
    @RequestMapping(value = "/approveProduct", method = RequestMethod.POST)
    public ReturnMessage<Object> approveProduct(ApproveProduct approveProduct) {
        approveService.approveProduct(approveProduct);
        return ReturnMessageUtil.success();
    }

    @Admin
    @RequestMapping(value = "/findAllStore", method = RequestMethod.GET)
    public ReturnMessage<Object> findAllStore(Map<String, String> option) {
        return ReturnMessageUtil.success(approveService.findAllStore(option));
    }

    @Admin
    @RequestMapping(value = "/findAllProduct", method = RequestMethod.GET)
    public ReturnMessage<Object> findAllProduct(Map<String, String> option) {
        return ReturnMessageUtil.success(approveService.findAllProduct(option));
    }

    @LoginUser
    @RequestMapping(value = "/findStoreByUserId/{userId}", method = RequestMethod.GET)
    public ReturnMessage<Object> findStoreByUserId(@PathVariable long userId, HttpServletRequest request) {
        return ReturnMessageUtil.success(approveService.findStoreByUserId(userId, request.getHeader("Authorization")));
    }
}