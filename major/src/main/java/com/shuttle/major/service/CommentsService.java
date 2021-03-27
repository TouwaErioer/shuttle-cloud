package com.shuttle.major.service;

import com.shuttle.major.entity.Comments;
import com.shuttle.major.entity.Page;

import java.util.Map;

public interface CommentsService {

    void insert(String token, Comments comments);

    void delete(Comments comments, String token);

    void update(Comments comments, String token);

    Page<Comments> findByStoreId(long storeId, Map<String, String> option);

    Page<Comments> findAll(Map<String, String> option);
}