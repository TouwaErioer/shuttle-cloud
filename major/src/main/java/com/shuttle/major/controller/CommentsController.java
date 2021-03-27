package com.shuttle.major.controller;

import com.shuttle.major.entity.Comments;
import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.service.CommentsService;
import com.shuttle.major.utils.ReturnMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    private CommentsService commentsService;

    @Autowired
    public CommentsController(CommentsService commentsService) {
        this.commentsService = commentsService;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Comments comments, HttpServletRequest request) {
        commentsService.insert(request.getHeader("Authorization"), comments);
        return ReturnMessageUtil.sucess();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(Comments comments, HttpServletRequest request) {
        commentsService.delete(comments, request.getHeader("Authorization"));
        return ReturnMessageUtil.sucess();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Comments comments, HttpServletRequest request) {
        commentsService.update(comments, request.getHeader("Authorization"));
        return ReturnMessageUtil.sucess();
    }

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(commentsService.findAll(option));
    }

    @RequestMapping(value = "/findByStoreId/{storeId}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByStoreId(@PathVariable long storeId, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(commentsService.findByStoreId(storeId, option));
    }
}
