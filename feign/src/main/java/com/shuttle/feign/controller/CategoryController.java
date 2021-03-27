package com.shuttle.feign.controller;

import com.shuttle.feign.annotation.Admin;
import com.shuttle.feign.annotation.LoginUser;
import com.shuttle.feign.entity.Category;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fetch.CategoryFetch;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @description: 类别相关路由
 * @author: DHY
 * @created: 2020/10/30 13:49
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryFetch categoryFetch;

    @Admin
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Category category) {
        return categoryFetch.insert(category);
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        return categoryFetch.delete(id);
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Category category) {
        return categoryFetch.update(category);
    }

    @Admin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(Map<String, String> option) {
        return categoryFetch.findAll(option);
    }

    @LoginUser
    @RequestMapping(value = "/findAllByServiceId/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findAllByServiceId(@PathVariable long id) {
        return categoryFetch.findAllByServiceId(id);
    }

    @RequestMapping(value = "/exit/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> exit(@PathVariable long id) {
        return categoryFetch.exist(id);
    }
}