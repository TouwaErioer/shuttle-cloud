package com.shuttle.orders.controller;

import com.shuttle.orders.annotation.Admin;
import com.shuttle.orders.annotation.LoginUser;
import com.shuttle.orders.entity.Orders;
import com.shuttle.orders.entity.ReturnMessage;
import com.shuttle.orders.service.OrderService;
import com.shuttle.orders.utils.ReturnMessageUtil;
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
@RequestMapping("/orders")
public class OrderController {

    @Resource
    private OrderService orderService;

    @LoginUser
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(@RequestBody List<Orders> orderList, @RequestParam(defaultValue = "false") boolean isExpired) {
        orderService.insert(orderList, isExpired);
        return ReturnMessageUtil.sucess();
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(@RequestBody List<Orders> orders, HttpServletRequest request) {
        orderService.delete(orders, request.getHeader("authorization"));
        return ReturnMessageUtil.sucess();
    }

    @Admin
    @RequestMapping(value = "/deleteByUserId", method = RequestMethod.DELETE)
    public ReturnMessage<Object> deleteByUserId(long userId) {
        orderService.deleteByUserId(userId);
        return ReturnMessageUtil.sucess();
    }

    @LoginUser
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> update(Orders order) {
        orderService.update(order);
        return ReturnMessageUtil.sucess();
    }

    @LoginUser
    @RequestMapping(value = "/receive", method = RequestMethod.POST)
    public ReturnMessage<Object> receive(long orderId, long userId) {
        orderService.receive(orderId, userId);
        return ReturnMessageUtil.sucess();
    }

    @Admin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.findAll(option));
    }

    @LoginUser
    @RequestMapping(value = "/findByPid/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByPid(@PathVariable long id, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.findByPid(id, option));
    }

    @LoginUser
    @RequestMapping(value = "/findByCid/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByCid(@PathVariable long id, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.findByCid(id, option));
    }

    @LoginUser
    @RequestMapping(value = "/findByCidOrOrder/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByCidOrOrder(@PathVariable long id, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.findByCidOrOrder(id, option));
    }

    @LoginUser
    @RequestMapping(value = "/findByCidOrPresent/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByCidOrPresent(@PathVariable long id, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.findByCidOrPresent(id, option));
    }

    @LoginUser
    @RequestMapping(value = "/findByCidOrCompleted/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByCidOrCompleted(@PathVariable long id, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.findByCidOrCompleted(id, option));
    }

    @LoginUser
    @RequestMapping(value = "/findBySidOrCompleted/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findBySidOrCompleted(@PathVariable long id, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.findBySidOrCompleted(id, option));
    }

    @LoginUser
    @RequestMapping(value = "/findBySidOrPresent/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findBySidOrPresent(@PathVariable long id, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.findBySidOrPresent(id, option));
    }

    @LoginUser
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findById(@PathVariable long id) {
        return ReturnMessageUtil.sucess(orderService.findById(id));
    }

    @LoginUser
    @RequestMapping(value = "/completed", method = RequestMethod.POST)
    public ReturnMessage<Object> completed(HttpServletRequest request, Orders orders) {
        orderService.completed(orders, request.getHeader("authorization"));
        return ReturnMessageUtil.sucess();
    }

    @LoginUser
    @RequestMapping(value = "/findByReceive", method = RequestMethod.GET)
    public ReturnMessage<Object> findByReceive(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.findByReceive(option));
    }

    @LoginUser
    @RequestMapping(value = "/findByCompleted", method = RequestMethod.GET)
    public ReturnMessage<Object> findByCompleted(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.findByCompleted(option));
    }

    @LoginUser
    @RequestMapping(value = "/findByPresent", method = RequestMethod.GET)
    public ReturnMessage<Object> findByPresent(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.findByPresent(option));
    }

    @LoginUser
    @RequestMapping(value = "/searchByCid/{userId}", method = RequestMethod.GET)
    public ReturnMessage<Object> searchByCid(@RequestParam String start, @RequestParam String end,
                                             @RequestParam Long productId, @RequestParam Long serverId,
                                             @RequestParam int status, @PathVariable long userId,
                                             @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.searchByCid(userId, start, end, productId, serverId, status, option));
    }

    @LoginUser
    @RequestMapping(value = "/searchByReceive", method = RequestMethod.GET)
    public ReturnMessage<Object> searchByReceive(@RequestParam String start, @RequestParam String end,
                                                 @RequestParam long serviceId, @RequestParam String address,
                                                 @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.sucess(orderService.searchByReceive(start, end, serviceId, address, option));
    }
}