package com.shuttle.major.service;

import com.github.pagehelper.PageInfo;
import com.shuttle.major.entity.ApproveProduct;
import com.shuttle.major.entity.ApproveStore;

import java.util.List;
import java.util.Map;

public interface ApproveService {

    void insertStore(ApproveStore approveStore, String token);

    void insertProduct(ApproveProduct approveProduct, String token);

    void approveStore(ApproveStore approveStore);

    void approveProduct(ApproveProduct approveProduct);

    PageInfo<ApproveStore> findAllStore(Map<String, String> option);

    PageInfo<ApproveProduct> findAllProduct(Map<String, String> option);

    List<String> findStoreByUserId(long userId, String token);
}