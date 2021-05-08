package com.shuttle.major.controller;

import com.shuttle.major.annotation.LoginUser;
import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.entity.Star;
import com.shuttle.major.service.StarService;
import com.shuttle.major.utils.ReturnMessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description: 收藏相关路由
 * @author: DHY
 * @created: 2021/04/27 14:36
 */

@RestController
@RequestMapping("/major/star")
public class StarController {

    @Resource
    private StarService starService;

    @LoginUser
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Star star, HttpServletRequest request) {
        starService.insert(star,request.getHeader("Authorization"));
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(Star star, HttpServletRequest request) {
        starService.delete(star, request.getHeader("Authorization"));
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/findByStore", method = RequestMethod.GET)
    public ReturnMessage<Object> findByStore(HttpServletRequest request, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(starService.findByStore(request.getHeader("Authorization"), option));
    }

    @LoginUser
    @RequestMapping(value = "/findByProduct", method = RequestMethod.GET)
    public ReturnMessage<Object> findByProduct(HttpServletRequest request, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(starService.findByProduct(request.getHeader("Authorization"), option));
    }

    @LoginUser
    @RequestMapping(value = "/isStarByStoreId/{storeId}", method = RequestMethod.GET)
    public ReturnMessage<Object> isStarByStoreId(@PathVariable long storeId, HttpServletRequest request) {
        return ReturnMessageUtil.success(starService.isStarByStoreId(request.getHeader("Authorization"), storeId));
    }

    @LoginUser
    @RequestMapping(value = "/isStarByProductId/{productId}", method = RequestMethod.GET)
    public ReturnMessage<Object> isStarByProductId(@PathVariable long productId, HttpServletRequest request) {
        return ReturnMessageUtil.success(starService.isStarByProductId(request.getHeader("Authorization"), productId));
    }
}