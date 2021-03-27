package com.shuttle.feign.fetch;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fallback.FileFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(value = "orders",fallback = FileFallback.class)
public interface FileFetch {

    @PostMapping("/file/upload")
    ReturnMessage<Object> upload(MultipartFile file);

    @GetMapping("/file/download/{fileName}")
    ResponseEntity<Object> download(@PathVariable String fileName);
}