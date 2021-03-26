package com.shuttle.major.common.provider;

import java.util.Map;

/**
 * @description: 订单表sql提供类
 * @author: DHY
 * @created: 2021/02/04 17:01
 */
public class OrdersProvider {

    private static final String SQL = "select " +
            "orders.*," +
            "client.name as clientName," +
            "client.phone as clientPhone," +
            "client.address as ClientAddress," +
            "service.name as serviceName," +
            "service.phone as servicePhone," +
            "product.name as productName," +
            "product.image as productImage," +
            "product.price as productPrice," +
            "round(product.rate,1) as productRate," +
            "product.sales as productSales," +
            "store.name as storeName," +
            "store.serviceId as serviceId," +
            "store.id as storeId " +
            "from " +
            "orders," +
            "user as client," +
            "user as service," +
            "product " +
            "left join " +
            "store " +
            "on " +
            "product.storeId = store.id " +
            "where " +
            "orders.cid = client.id and " +
            "orders.sid = service.id and " +
            "orders.pid = product.id";

    public String selectByKey(Map<String, Object> para){
        return Provider.selectByKey(para, SQL,"orders");
    }
}
