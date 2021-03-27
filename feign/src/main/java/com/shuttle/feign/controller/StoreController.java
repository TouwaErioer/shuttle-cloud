package com.shuttle.feign.controller;

import com.shuttle.feign.annotation.Admin;
import com.shuttle.feign.annotation.LoginUser;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.entity.Store;
import com.shuttle.feign.fetch.StoreFetch;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 商店相关路由
 * @author: DHY
 * @created: 2021/02/03 19:56
 */

@RestController
@RequestMapping("/store")
public class StoreController {

    @Resource
    private StoreFetch storeFetch;

    @Admin
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Store store) {
        return storeFetch.insert(store);
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        return storeFetch.delete(id);
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Store store) {
        return storeFetch.update(store);
    }

    @Admin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return storeFetch.findAll(option);
    }

    @LoginUser
    @RequestMapping(value = "/findByServiceId/{serviceId}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByServiceId(@PathVariable("serviceId") long serviceId,
                                                 @RequestParam Map<String, String> option) {
        return storeFetch.findByServiceId(serviceId, option);
    }

    @LoginUser
    @RequestMapping(value = "/findByCategoryId/{categoryId}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByCategoryId(@PathVariable("categoryId") long categoryId) {
        return storeFetch.findByCategoryId(categoryId);
    }

    @LoginUser
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findById(@PathVariable("id") long id) {
        return storeFetch.findById(id);
    }

    @LoginUser
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public ReturnMessage<Object> rank() {
        return storeFetch.rank();
    }

    @LoginUser
    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
    public ReturnMessage<Object> search(@PathVariable("keyword") String keyword, @RequestParam Map<String, String> option) {
        return storeFetch.search(keyword, option);
    }

    @RequestMapping(value = "/exist/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> exist(@PathVariable("id") long id) {
        return storeFetch.exist(id);
    }
}