package com.shuttle.major.repository;

import com.shuttle.major.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, Long> {

    List<Product> queryProductByName(String name);
}
