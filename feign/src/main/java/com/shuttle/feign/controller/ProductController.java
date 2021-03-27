package com.shuttle.feign.controller;

import com.shuttle.feign.annotation.Admin;
import com.shuttle.feign.annotation.LoginUser;
import com.shuttle.feign.entity.Product;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fetch.ProductFetch;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Resource
    private ProductFetch productFetch;

    @Admin
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ReturnMessage<Object> insert(Product product) {
        return productFetch.insert(product);
    }

    @Admin
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ReturnMessage<Object> delete(long id) {
        return productFetch.delete(id);
    }

    @Admin
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ReturnMessage<Object> updateProduct(Product product) {
        return productFetch.update(product);
    }

    @Admin
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public ReturnMessage<Object> findAll(@RequestParam Map<String, String> option) {
        return productFetch.findAll(option);
    }

    @LoginUser
    @RequestMapping(value = "/findByStoreId/{storeId}", method = RequestMethod.GET)
    public ReturnMessage<Object> findByStoreId(@PathVariable("storeId") long storeId) {
        return productFetch.findByStoreId(storeId);
    }

    @LoginUser
    @RequestMapping(value = "/findById/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> findById(@PathVariable("id") long id) {
        return productFetch.findById(id);
    }

    @LoginUser
    @RequestMapping(value = "/review", method = RequestMethod.POST)
    public ReturnMessage<Object> review(Product product, HttpServletRequest request) {
        return productFetch.review(product, request.getHeader("Authorization"));
    }

    @LoginUser
    @RequestMapping(value = "/rank", method = RequestMethod.GET)
    public ReturnMessage<Object> rank() {
        return productFetch.rank();
    }

    @LoginUser
    @RequestMapping(value = "/search/{keyword}", method = RequestMethod.GET)
    public ReturnMessage<Object> search(@PathVariable("keyword") String keyword, @RequestParam Map<String, String> option) {
        return productFetch.search(keyword, option);
    }

    @RequestMapping(value = "/exist/{id}", method = RequestMethod.GET)
    public ReturnMessage<Object> exist(@PathVariable("id") long id, @RequestParam Map<String, String> option) {
        return productFetch.exist(id);
    }
}