package com.shuttle.feign.controll;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.fetch.FileFetch;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @description: 文件控制器
 * @author: DHY
 * @created: 2021/02/08 17:37
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    private FileFetch fileFetch;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public ReturnMessage<Object> upload(MultipartFile file) {
        return fileFetch.upload(file);
    }

    @RequestMapping(value = "/download/{fileName}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Object> download(@PathVariable("fileName") String fileName) {
        return fileFetch.download(fileName);
    }
}