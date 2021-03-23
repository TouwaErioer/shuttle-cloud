package com.shuttle.user.mapper;

import com.shuttle.user.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface UserMapper {

    @Insert("insert into user(password,phone,address,name) values(#{password},#{phone},#{address},#{name})")
    int insert(User user);

    @Delete("delete from user where id = #{id}")
    int delete(long id);

    @Update("update user set address = #{address},name = #{name},phone = #{phone} where id = #{id}")
    int update(User user);

    @Update("update user set password = #{password} where id = #{id}")
    int updatePassword(long id, String password);

    @Update("update user set score = score + #{quantity} where id = #{id}")
    int addScore(long id, int quantity);

    @Update("update user set score = score - 1 where id = #{id}")
    int reduceScore(long id);

    @Select("select id,phone,address,admin,score,name from user where id = #{id}")
    List<User> findUserById(long id);

    @Select("select id,phone,address,admin,score,name from user")
    List<User> findAll();

    @Select("select id,phone,address,score,name,admin from user where (phone = #{account} or name = #{account}) and" +
            " password = #{encryption_password}")
    User login(String account, String encryption_password);

    @Select("select id,phone,address,admin,score,name from user where phone = #{phone}")
    List<User> findByPhone(String phone);

    @Select("select score from user where id = #{id}")
    int findByScore(long id);

    @Select("select * from user where phone like #{keyword} or name like #{keyword}")
    List<User> search(String keyword);

    @Update("update user set admin = 1 where id = #{id}")
    int admin(long id);
}
