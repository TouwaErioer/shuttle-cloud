package com.shuttle.major.repository;

import com.shuttle.major.entity.Store;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface StoreRepository extends ElasticsearchRepository<Store, Long> {

    List<Store> queryStoreByName(String name);

    @Override
    Optional<Store> findById(Long aLong);
}
