package com.shuttle.user.utils;

import cn.hutool.core.lang.Validator;
import com.shuttle.user.config.exception.BusinessException;
import com.shuttle.user.entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Map;

/**
 * @description: 工具类
 * @author: DHY
 * @created: 2020/10/27 13:01
 */
public class Utils {


    public static Map<String, String> checkOption(Map<String, String> option, Class clazz) {

        if (clazz != null) {
            if (!option.containsKey("sort")) {
                option.put("sort", "id");
            } else {
                boolean isSort = false;
                for (Field field : clazz.getDeclaredFields())
                    if (option.get("sort").equals(field.getName())) isSort = true;
                if (!isSort) throw new BusinessException(1, "sort参数错误");
            }

            if (!option.containsKey("order")) {
                option.put("order", "DESC");
            } else {
                String order = option.get("order");
                if (!order.equals("ASC") && !order.equals("DESC")) {
                    throw new BusinessException(1, "order参数错误");
                }
            }
        }

        if (!option.containsKey("pageNo")) {
            option.put("pageNo", "1");
        } else {
            try {
                int pageNo = Integer.parseInt(option.get("pageNo"));
                pageNo = pageNo <= 0 ? 0 : pageNo;
                option.put("pageNo", String.valueOf(pageNo));
            } catch (NumberFormatException e) {
                throw new BusinessException(1, "pageNo参数错误");
            }
        }

        if (!option.containsKey("pageSize")) {
            option.put("pageSize", "9");
        } else {
            try {
                int pageSize = Integer.parseInt(option.get("pageSize"));
                pageSize = pageSize <= 0 ? 1 : pageSize;
                option.put("pageSize", String.valueOf(pageSize));
            } catch (NumberFormatException e) {
                throw new BusinessException(1, "pageSize参数错误");
            }
        }

        return option;
    }

    public static void check_user(User user) {
        if (!Validator.isMobile(user.getPhone())) {
            throw new BusinessException(1, "手机号格式不正确");
        }
    }

    public static String encode(String password) {
        return DigestUtils.md5Hex(password);
    }

    /**
     * 根据时间戳生成订单号
     */
    public static String getOrderNo() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
        LocalDateTime localDateTime = Instant.ofEpochMilli(System.currentTimeMillis()).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();
        return df.format(localDateTime);
    }

    public static String getKey(String fileName) throws IOException {
        String workPath = System.getProperty("user.dir");
        String path = workPath + File.separator + fileName;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null)
                reader.close();
        }
        return null;
    }

}