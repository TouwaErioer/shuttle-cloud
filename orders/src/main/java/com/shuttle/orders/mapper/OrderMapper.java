package com.shuttle.orders.mapper;

import com.shuttle.orders.common.provider.Provider;
import com.shuttle.orders.entity.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface OrderMapper {

    // 批量添加订单
    int insertBatch(List<Orders> orderList);

    // 批量删除订单
    int deleteBatch(List<Orders> orders);

    @Insert("insert into orders(cid,sid,pid,date,address,note,file,status) values(#{cid},#{sid},#{pid},#{date},#{address},#{note},#{file},#{status})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Orders order);

    @Delete("delete from orders where ${key} = #{id}")
    int delete(long id, String key);

    @Delete("delete from orders where cid = #{userId} or sid = #{userId}")
    int deleteByUserId(long userId);

    @Update("update orders set address = #{address},date = #{date},note = #{note},file = #{file},status = #{status} where id = #{id}")
    int update(Orders order);

    @SelectProvider(type = Provider.class, method = "selectByKey")
    List<Orders> select(@Param("id") String id, @Param("key") String key, @Param("status") String status);

    @Update("update orders set status = 0,sid = #{sid} where id = #{id}")
    int receive(long id, long sid);

    @Update("update orders set status = 1 where id = #{id}")
    int completed(long id);
}
