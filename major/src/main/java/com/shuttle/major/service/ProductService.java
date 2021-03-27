package com.shuttle.major.service;

import com.github.pagehelper.PageInfo;
import com.shuttle.major.entity.Product;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;
import java.util.Map;

public interface ProductService {

    void insert(Product product);

    void delete(long id);

    void update(Product product);

    void review(Product product, String token);

    List<Product> rank();

    SearchHits<Product> search(String keyword, Map<String, String> option);

    PageInfo<Product> findAll(Map<String, String> option);

    List<Product> findByStoreId(long storeId);

    Product findById(long id);

    boolean exist(long id);

    void addSales(long id, int sales);
}