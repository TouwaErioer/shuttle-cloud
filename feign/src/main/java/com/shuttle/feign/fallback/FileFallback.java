package com.shuttle.feign.fallback;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fetch.FileFetch;
import com.shuttle.feign.utils.ReturnMessageUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: DHY
 * @created: 2021/03/26 17:55
 */
@Component
public class FileFallback implements FileFetch {
    @Override
    public ReturnMessage<Object> upload(MultipartFile file) {
        return ReturnMessageUtil.error(-1, "系统错误");
    }

    @Override
    public ResponseEntity<Object> download(String fileName) {
        return null;
    }
}