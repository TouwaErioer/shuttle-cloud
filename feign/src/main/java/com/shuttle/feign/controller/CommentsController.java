package com.shuttle.feign.controller;

import com.shuttle.feign.annotation.Admin;
import com.shuttle.feign.annotation.LoginUser;
import com.shuttle.feign.entity.Comments;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fetch.CommentFetch;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @description: 评论相关路由
 * @author: DHY
 * @created: 2021/02/17 13:57
 */
@RestController
@RequestMapping("/comments")
public class CommentsController {

    @Resource
    private CommentFetch commentFetch;

    @LoginUser
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Comments comments, HttpServletRequest request) {
        return commentFetch.insert(request.getHeader("Authorization"), comments);
    }

    @LoginUser
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(Comments comments, HttpServletRequest request) {
        return commentFetch.delete(comments, request.getHeader("Authorization"));
    }

    @LoginUser
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Comments comments, HttpServletRequest request) {
        return commentFetch.update(comments, request.getHeader("Authorization"));
    }

    @Admin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return commentFetch.findAll(option);
    }

    @LoginUser
    @RequestMapping(value = "/findByStoreId/{storeId}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByStoreId(@PathVariable long storeId, @RequestParam Map<String, String> option) {
        return commentFetch.findByStoreId(storeId, option);
    }
}
