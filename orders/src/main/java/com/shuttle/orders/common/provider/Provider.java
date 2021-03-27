package com.shuttle.orders.common.provider;

import java.util.Map;

/**
 * @description: SQL公共提供类
 * @author: DHY
 * @created: 2021/02/08 13:39
 */
public class Provider {

    public static String selectByKey(Map<String, Object> para) {
        StringBuilder stringBuffer = new StringBuilder();
        stringBuffer.append("select * from orders");
        if (para.get("key") != null && para.get("id") != null) {
            stringBuffer.append(" where orders.").append(para.get("key")).append(" = ")
                    .append(para.get("id"));
            if (para.get("status") != null && !para.get("key").equals("status"))
                stringBuffer.append(" and status = ").append(para.get("status"));
        }
        return stringBuffer.toString();
    }
}