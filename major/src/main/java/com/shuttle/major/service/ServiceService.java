package com.shuttle.major.service;

import com.github.pagehelper.PageInfo;
import com.shuttle.major.entity.Services;

import java.util.List;
import java.util.Map;

public interface ServiceService {

    void insert(Services services);

    void delete(Long id);

    void update(Services services);

    PageInfo<Services> findAll(Map<String, String> option);

    List<Services> findById(long id);

    boolean exist(long id);
}
