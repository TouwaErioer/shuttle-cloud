package com.shuttle.major.repository.mongo;

import com.shuttle.major.entity.Comments;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CommentsRepository extends MongoRepository<Comments, String> {

    List<Comments> findByContent(String content);

    List<Comments> findByStoreId(long storeId);

    List<Comments> findByName(String name);
}
