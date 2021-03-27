package com.shuttle.orders.config.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shuttle.orders.entity.ReturnMessage;
import lombok.Data;

@Data
public class BusinessException extends RuntimeException {

    private int code;
    private String message;

    public BusinessException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static void check(int res,String message){
        if(res < 1){
            throw new BusinessException(0,message);
        }
    }

    public static Object checkReturnMessage(ReturnMessage returnMessage) {
        if (returnMessage.getCode() < 1) {
            System.out.println(returnMessage);
            throw new BusinessException(returnMessage.getCode(), returnMessage.getMessage());
        }
        return returnMessage.getData();
    }
}