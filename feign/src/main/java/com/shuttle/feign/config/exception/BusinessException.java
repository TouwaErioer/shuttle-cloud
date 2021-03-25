package com.shuttle.feign.config.exception;

import com.shuttle.feign.entity.ReturnMessage;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    private int code;
    private String message;

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static void check(ReturnMessage returnMessage) {
        if (returnMessage.getCode() < 1) {
            throw new BusinessException(returnMessage.getCode(), returnMessage.getMessage());
        }
    }
}