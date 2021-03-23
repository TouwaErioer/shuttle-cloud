package com.shuttle.user.repository;

import com.shuttle.user.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, Long> {

    List<User> queryUserByNameOrPhone(String keyword);
}