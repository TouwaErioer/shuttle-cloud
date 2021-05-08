package com.shuttle.major.service;

import com.github.pagehelper.PageInfo;
import com.shuttle.major.entity.Product;
import com.shuttle.major.entity.Store;
import org.springframework.data.elasticsearch.core.SearchHits;

import java.util.List;
import java.util.Map;

public interface StoreService {

    void insert(Store store);

    void delete(long id);

    void deleteByCategoryId(long categoryId);

    void update(Store store);

    List<Store> rank(Map<String, String> option);

    void sales(long id, int quantity);

    SearchHits search(String keyword, Map<String, String> option);

    Map<Long, Store> batchQueryStore(List<Long> StoreIds);

    PageInfo<Store> findAll(Map<String, String> option);

    PageInfo<Store> findByServiceId(long serviceId, Map<String, String> option);

    List<Store> findByCategoryId(long categoryId);

    PageInfo<Store> findByCategoryId(long categoryId, Map<String, String> option);

    List<Store> findById(long id);

    void review(long id, float rate, String token);

    boolean exist(long id);

    List<Store> findByName(String name);
}