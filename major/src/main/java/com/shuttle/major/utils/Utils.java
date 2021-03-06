package com.shuttle.major.utils;

import com.shuttle.major.config.exception.BusinessException;
import java.lang.reflect.Field;
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
                option.put("order", "ASC");
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

    /**
     * 检查rank quantity
     *
     * @return option
     */
    public static Map<String, String> checkQuantity(Map<String, String> option) {
        if (!option.containsKey("quantity") || Integer.parseInt(option.get("quantity")) <= 0)
            option.put("quantity", "9");
        return option;
    }

    /**
     * 排行榜算法
     *
     * @param rate  评分
     * @param sales 销量
     */
    public static double changeRate(double rate, double sales) {
        if (sales == 0) sales = 1;
        return sales * rate;
    }
}