package com.shuttle.orders.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;

public interface FileService {

    String upload(MultipartFile file);

    ResponseEntity<Object> download(String fileName) throws FileNotFoundException;


    void remove(String fileName);
}
