package com.shuttle.feign.fetch;

import com.shuttle.feign.entity.Orders;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fallback.OrdersFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/26 17:35
 */
@FeignClient(value = "orders",fallback = OrdersFallback.class)
public interface OrdersFetch {

    @PostMapping("/orders/insert")
    ReturnMessage<Object> insert(@RequestBody List<Orders> orderList, @RequestParam("isExpired") boolean isExpired);

    @DeleteMapping("/orders/delete")
    ReturnMessage<Object> delete(List<Orders> orders, @RequestParam("token") String token);

    @PostMapping("/orders/update")
    ReturnMessage<Object> update(@RequestBody Orders order);

    @PostMapping("/orders/receive")
    ReturnMessage<Object> receive(@RequestParam("id") long id, @RequestParam("userId") long userId);

    @PostMapping("/orders/completed")
    ReturnMessage<Object> completed(@RequestBody Orders orders, @RequestParam("token") String token);

    @GetMapping("/orders/findAll")
    ReturnMessage<Object> findAll(Map<String, String> option);

    @GetMapping("/orders/findByPid/{pid}")
    ReturnMessage<Object> findByPid(@PathVariable long pid, Map<String, String> option);

    @GetMapping("/orders/findByCid/{cid}")
    ReturnMessage<Object> findByCid(@PathVariable long cid, Map<String, String> option);

    @GetMapping("/orders/findBySidOrCompleted/{sid}")
    ReturnMessage<Object> findBySidOrCompleted(@PathVariable long sid, Map<String, String> option);

    @GetMapping("/orders/findBySidOrPresent/{sid}")
    ReturnMessage<Object> findBySidOrPresent(@PathVariable long sid, Map<String, String> option);

    @GetMapping("/orders/findById/{id}")
    ReturnMessage<Object> findById(@PathVariable long id);

    @GetMapping("/orders/findByReceive")
    ReturnMessage<Object> findByReceive(Map<String, String> option);

    @GetMapping("/orders/findByCompleted")
    ReturnMessage<Object> findByCompleted(Map<String, String> option);

    @GetMapping("/orders/findByPresent")
    ReturnMessage<Object> findByPresent(Map<String, String> option);

    @GetMapping("/orders/exist/{id}")
    ReturnMessage<Object> exist(@PathVariable long id);
}