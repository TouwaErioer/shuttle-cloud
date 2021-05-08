package com.shuttle.major.service;

import com.github.pagehelper.PageInfo;
import com.shuttle.major.entity.Star;

import java.util.List;
import java.util.Map;

public interface StarService {

    void insert(Star star, String token);

    void delete(Star star, String token);

    PageInfo<Star> findByStore(String token, Map<String, String> option);

    PageInfo<Star> findByProduct(String token, Map<String, String> option);

    List<Star> isStarByStoreId(String token, long storeId);

    List<Star> isStarByProductId(String token, long productId);
}