package com.shuttle.major.mapper;

import com.shuttle.major.common.provider.StoreProvider;
import com.shuttle.major.entity.Product;
import com.shuttle.major.entity.Store;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@Mapper
public interface StoreMapper {

    @Insert("insert into store(name,serviceId,categoryId,image,rate,sales) values(#{name},#{serviceId},#{categoryId},#{image},#{rate},#{sales})")
    int insert(Store store);

    @Delete("delete from store where ${key} = #{id}")
    int delete(long id, String key);

    @Update("update store set name = #{name}, serviceId = #{serviceId}, categoryId = #{categoryId}, image = #{image}, rate = #{rate}, sales = #{sales} where id = #{id}")
    int update(Store store);

    List<Store> batchQueryStore(Map<String, Object> storeIdsParam);

    @SelectProvider(type = StoreProvider.class, method = "selectByKey")
    @Results(value = {
            @Result(column = "serviceName", property = "services.name"),
            @Result(column = "serviceColor", property = "services.color"),
            @Result(column = "categoryName", property = "category.name")
    })
    List<Store> select(@Param("id") String id, @Param("key") String key);

    @Update("update store set sales = sales + #{quantity} where id = #{id}")
    int sales(long id, int quantity);

    @Update("update store set rate = (rate * sales + #{rate}) / (sales + 1) where id = #{id}")
    int review(long id, float rate);

    @Select("select * from store where name = #{name}")
    List<Store> findByName(String name);
}