package com.shuttle.major.service;

import com.github.pagehelper.PageInfo;
import com.shuttle.major.entity.Category;

import java.util.List;
import java.util.Map;

public interface CategoryService {

    void insert(Category category);

    void delete(long id);

    void update(Category category);

    PageInfo<Category> findAll(Map<String, String> option);

    List<Category> findAllByServiceId(long serviceId);

    boolean exist(long id);

    List<Category> findById(long id);
}
