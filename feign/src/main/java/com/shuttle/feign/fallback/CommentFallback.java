package com.shuttle.feign.fallback;

import com.shuttle.feign.entity.Comments;
import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fetch.CommentFetch;
import com.shuttle.feign.utils.ReturnMessageUtil;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/27 09:30
 */
@Component
public class CommentFallback implements CommentFetch {
    @Override
    public ReturnMessage<Object> insert(String token, Comments comments) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> delete(Comments comments, String token) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> update(Comments comments, String token) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findByStoreId(long storeId, Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ReturnMessage<Object> findAll(Map<String, String> option) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }
}
