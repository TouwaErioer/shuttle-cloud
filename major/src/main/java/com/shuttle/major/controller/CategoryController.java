package com.shuttle.major.controller;

import com.shuttle.major.annotation.Admin;
import com.shuttle.major.annotation.LoginUser;
import com.shuttle.major.entity.Category;
import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.service.CategoryService;
import com.shuttle.major.utils.ReturnMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/major/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    @Admin
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Category category) {
        categoryService.insert(category);
        return ReturnMessageUtil.sucess();
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        categoryService.delete(id);
        return ReturnMessageUtil.sucess();
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Category category) {
        categoryService.update(category);
        return ReturnMessageUtil.sucess();
    }

    @Admin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(Map<String, String> option) {
        return ReturnMessageUtil.sucess(categoryService.findAll(option));
    }

    @LoginUser
    @RequestMapping(value = "/findAllByServiceId/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findAllByServiceId(@PathVariable long id) {
        return ReturnMessageUtil.sucess(categoryService.findAllByServiceId(id));
    }

    @LoginUser
    @RequestMapping(value = "/exit/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> exit(@PathVariable long id) {
        return ReturnMessageUtil.sucess(categoryService.exist(id));
    }
}