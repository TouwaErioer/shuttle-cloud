package com.shuttle.major.mapper;

import com.shuttle.major.entity.ApproveProduct;
import com.shuttle.major.entity.ApproveStore;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ApproveMapper {

    @Insert("insert into approve_store(uid,status,name,image,serviceId,categoryId,categoryName) values(#{uid},#{status},#{name},#{image},#{serviceId},#{categoryId},#{categoryName})")
    int insertStore(ApproveStore approveStore);

    @Insert("insert into approve_product(uid,status,name,image,price,storeName) values(#{uid},#{status},#{name},#{image},#{price},#{storeName})")
    int insertProduct(ApproveProduct approveProduct);

    @Update("update approve_store set status = #{status} where id = #{id}")
    int approveStore(long id, int status);

    @Update("update approve_product set status = #{status} where id = #{id}")
    int approveProduct(long id, int status);

    @Select("select * from approve_store where status = 0")
    List<ApproveStore> findAllStore();

    @Select("select * from approve_product where status = 0")
    List<ApproveProduct> findAllProduct();

    @Select("select name from approve_store where uid = #{userId} and status = 1")
    List<String> findStoreByUserId(long userId);

}