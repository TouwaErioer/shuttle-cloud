package com.shuttle.orders.controller;

import com.shuttle.orders.entity.ReturnMessage;
import com.shuttle.orders.service.FileService;
import com.shuttle.orders.service.implement.FileServiceImp;
import com.shuttle.orders.utils.ReturnMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.FileNotFoundException;

/**
 * @description: 文件控制器
 * @author: DHY
 * @created: 2021/02/08 17:37
 */

@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private FileService fileService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ReturnMessage<Object> upload(MultipartFile file) {
        return ReturnMessageUtil.sucess(fileService.upload(file));
    }

    @RequestMapping(value = "/download/{fileName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> download(@PathVariable("fileName") String fileName) throws FileNotFoundException {
        return fileService.download(fileName);
    }
}