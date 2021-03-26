package com.shuttle.major.config.elasticsearch;

import com.shuttle.major.entity.Product;
import com.shuttle.major.entity.Store;
import com.shuttle.major.repository.ProductRepository;
import com.shuttle.major.repository.StoreRepository;
import com.shuttle.major.service.ProductService;
import com.shuttle.major.service.StoreService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @description: 启动初始化es数据
 * @author: DHY
 * @created: 2021/02/28 15:25
 */
@Component
public class ElasticSearchRunner implements ApplicationRunner {

    @Resource
    private ProductRepository productRepository;

    @Resource
    private StoreRepository storeRepository;

    @Resource
    private ProductService productService;

    @Resource
    private StoreService storeService;

    @Override
    public void run(ApplicationArguments args) {
        productImportAll();
        StoreImportAll();
    }

    public void productImportAll() {
        List<Product> products = productService.findAll(new HashMap<>()).getList();
        productRepository.saveAll(products);
    }

    public void StoreImportAll() {
        List<Store> Stores = storeService.findAll(new HashMap<>()).getList();
        storeRepository.saveAll(Stores);
    }
}