package com.shuttle.major.mapper;

import com.shuttle.major.common.provider.CategoryProvider;
import com.shuttle.major.entity.Category;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CategoryMapper {

    @Insert("insert into category(name,serviceId) values(#{name},#{serviceId})")
    int insert(Category category);

    @Delete("delete from category where ${key} = #{id}")
    int delete(@Param("id") long id, @Param("key") String key);

    @Update("update category set name = #{name},serviceId = #{serviceId} where id = #{id}")
    int update(Category category);

    @SelectProvider(type = CategoryProvider.class, method = "selectByKey")
    @Results({
            @Result(column = "serviceName", property = "services.name"),
            @Result(column = "serviceColor", property = "services.color"),
            @Result(column = "serviceIcon", property = "services.icon")
    })
    List<Category> select(@Param("id") String id, @Param("key") String key);
}
