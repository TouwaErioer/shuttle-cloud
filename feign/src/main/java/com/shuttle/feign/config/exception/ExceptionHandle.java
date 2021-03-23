package com.shuttle.feign.config.exception;

import com.shuttle.feign.entity.ReturnMessage;
import com.shuttle.feign.utils.ReturnMessageUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public ReturnMessage<Object> handle(Exception exception) {
        // 业务异常 code:0
        if (exception instanceof BusinessException) {
            log.error(exception.getMessage());
            return ReturnMessageUtil.error(0, exception.getMessage());
        }

        log.error(exception.getMessage());

        // 系统异常 code:-1
        return ReturnMessageUtil.error(-1, "系统异常");
    }
}
