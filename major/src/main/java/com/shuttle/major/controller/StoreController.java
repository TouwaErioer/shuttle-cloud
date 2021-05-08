package com.shuttle.major.controller;

import com.shuttle.major.annotation.Admin;
import com.shuttle.major.annotation.LoginUser;
import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.entity.Store;
import com.shuttle.major.service.StoreService;
import com.shuttle.major.utils.ReturnMessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @description: 商店相关路由
 * @author: DHY
 * @created: 2021/02/03 19:56
 */

@RestController
@RequestMapping("/major/store")
public class StoreController {

    @Resource
    private StoreService storeService;

    @Admin
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Store store) {
        storeService.insert(store);
        return ReturnMessageUtil.success();
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        storeService.delete(id);
        return ReturnMessageUtil.success();
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Store store) {
        storeService.update(store);
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/batchQueryStoreId", method = RequestMethod.POST)
    public ReturnMessage<Map> batchQueryStoreId(@RequestParam List<Long> storeIds) {
        return new ReturnMessage<Map>(1, "success", storeService.batchQueryStore(storeIds));
    }

    @Admin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(storeService.findAll(option));
    }

    @LoginUser
    @RequestMapping(value = "/findByServiceId/{serviceId}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByServiceId(@PathVariable("serviceId") long serviceId,
                                                 @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(storeService.findByServiceId(serviceId, option));
    }

    @LoginUser
    @RequestMapping(value = "/findByCategoryId/{categoryId}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByCategoryId(@PathVariable("categoryId") long categoryId,
                                                  @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(storeService.findByCategoryId(categoryId, option));
    }

    @LoginUser
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findById(@PathVariable("id") long id) {
        return ReturnMessageUtil.success(storeService.findById(id).get(0));
    }

    @LoginUser
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public ReturnMessage<Object> rank(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(storeService.rank(option));
    }

    @LoginUser
    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
    public ReturnMessage<Object> search(@PathVariable("keyword") String keyword, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(storeService.search(keyword, option));
    }

    @LoginUser
    @RequestMapping(value = "/exist/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> exist(@PathVariable("id") long id) {
        return ReturnMessageUtil.success(storeService.exist(id));
    }

    @LoginUser
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public ReturnMessage<Object> review(long id, float rate, HttpServletRequest request) {
        storeService.review(id, rate, request.getHeader("Authorization"));
        return ReturnMessageUtil.success();
    }
}