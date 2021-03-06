package com.shuttle.major.controller;

import com.shuttle.major.annotation.Admin;
import com.shuttle.major.annotation.LoginUser;
import com.shuttle.major.entity.Product;
import com.shuttle.major.entity.ReturnMessage;
import com.shuttle.major.service.ProductService;
import com.shuttle.major.utils.ReturnMessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/major/product")
public class ProductController {

    @Resource
    private ProductService productService;

    @Admin
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Product product) {
        productService.insert(product);
        return ReturnMessageUtil.success();
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        productService.delete(id);
        return ReturnMessageUtil.success();
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> updateProduct(Product product) {
        productService.update(product);
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/batchQueryProductId", method = RequestMethod.POST)
    public ReturnMessage<Map> batchQueryProductId(@RequestParam List<Long> productIds) {
        return new ReturnMessage<Map>(1, "success", productService.batchQueryProduct(productIds));
    }

    @Admin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(productService.findAll(option));
    }

    @LoginUser
    @RequestMapping(value = "/findByStoreId/{storeId}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByStoreId(@PathVariable("storeId") long storeId) {
        return ReturnMessageUtil.success(productService.findByStoreId(storeId));
    }

    @LoginUser
    @RequestMapping(value = "/findByStoreIdByPagination/{storeId}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByStoreId(@PathVariable("storeId") long storeId, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(productService.findByStoreId(storeId, option));
    }

    @LoginUser
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findById(@PathVariable("id") long id) {
        return ReturnMessageUtil.success(productService.findById(id));
    }

    @LoginUser
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public ReturnMessage<Object> review(Product product, long orderId, HttpServletRequest request) {
        productService.review(product, request.getHeader("Authorization"), orderId);
        return ReturnMessageUtil.success();
    }

    @LoginUser
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public ReturnMessage<Object> rank(@RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(productService.rank(option));
    }

    @LoginUser
    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
    public ReturnMessage<Object> search(@PathVariable("keyword") String keyword, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(productService.search(keyword, option));
    }

    @LoginUser
    @RequestMapping(value = "/exist/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> exist(@PathVariable("id") long id, @RequestParam Map<String, String> option) {
        return ReturnMessageUtil.success(productService.exist(id));
    }

    @LoginUser
    @RequestMapping(value = "/addSales", method = RequestMethod.POST)
    public ReturnMessage<Object> addSales(long id, int sales) {
        productService.addSales(id, sales);
        return ReturnMessageUtil.success();
    }
}