package com.shuttle.feign.controller;

import com.shuttle.feign.annotation.Admin;
import com.shuttle.feign.annotation.LoginUser;
import com.shuttle.feign.entity.Orders;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fetch.OrdersFetch;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @description: 订单相关路由
 * @author: DHY
 * @created: 2020/10/25 14:20
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrdersFetch ordersFetch;

    @LoginUser
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(@RequestBody List<Orders> orderList, @RequestParam(defaultValue = "false") boolean isExpired) {
        return ordersFetch.insert(orderList, isExpired);
    }

    @LoginUser
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(@RequestBody List<Orders> orders, HttpServletRequest request) {
        return ordersFetch.delete(orders, request.getHeader("Authorization"));
    }

    @LoginUser
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Orders order) {
        return ordersFetch.update(order);
    }

    @LoginUser
    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    public ReturnMessage<Object> receive(long orderId, long userId) {
        return ordersFetch.receive(orderId, userId);
    }

    @Admin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return ordersFetch.findAll(option);
    }

    @LoginUser
    @RequestMapping(value = "/findByPid/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByPid(@PathVariable long id, @RequestParam Map<String, String> option) {
        return ordersFetch.findByPid(id, option);
    }

    @LoginUser
    @RequestMapping(value = "/findByCid/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByCid(@PathVariable long id, @RequestParam Map<String, String> option) {
        return ordersFetch.findByCid(id, option);
    }

    @LoginUser
    @RequestMapping(value = "/findBySidOrCompleted/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findBySidOrCompleted(@PathVariable long id, @RequestParam Map<String, String> option) {
        return ordersFetch.findBySidOrCompleted(id, option);
    }

    @LoginUser
    @RequestMapping(value = "/findBySidOrPresent/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findBySidOrPresent(@PathVariable long id, @RequestParam Map<String, String> option) {
        return ordersFetch.findBySidOrPresent(id, option);
    }

    @LoginUser
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findById(@PathVariable long id) {
        return ordersFetch.findById(id);
    }

    @LoginUser
    @RequestMapping(value = "/completed", method = RequestMethod.POST)
    public ReturnMessage<Object> completed(HttpServletRequest request, Orders orders) {
        return ordersFetch.completed(orders, request.getHeader("Authorization"));
    }

    @LoginUser
    @RequestMapping(value = "/findByReceive", method = RequestMethod.GET)
    public ReturnMessage<Object> findByReceive(@RequestParam Map<String, String> option) {
        return ordersFetch.findByReceive(option);
    }

    @LoginUser
    @RequestMapping(value = "/findByCompleted", method = RequestMethod.GET)
    public ReturnMessage<Object> findByCompleted(@RequestParam Map<String, String> option) {
        return ordersFetch.findByCompleted(option);
    }

    @LoginUser
    @RequestMapping(value = "/findByPresent", method = RequestMethod.GET)
    public ReturnMessage<Object> findByPresent(@RequestParam Map<String, String> option) {
        return ordersFetch.findByPresent(option);
    }
}