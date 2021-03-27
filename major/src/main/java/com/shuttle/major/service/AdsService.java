package com.shuttle.major.service;


import com.shuttle.major.entity.Ads;

import java.util.List;

public interface AdsService {

    void insert(Ads ads, int expired);

    void delete(long id);

    void update(Ads ads);

    List<Ads> findAll();
}
