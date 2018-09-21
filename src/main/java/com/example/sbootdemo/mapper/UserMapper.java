package com.example.sbootdemo.mapper;

import com.example.sbootdemo.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select id,name,password from user where id=#{id}")
    User findUserById(@Param("id") int id);

    @Update("update user set password=#{password} where id=#{id}")
    void modifyUser(@Param("id") String id, @Param("password") String password);

    @Insert("insert into user(id,name,password) values(#{id},#{name},#{password})")
    void addUser(@Param("id") String id, @Param("name") String name, @Param("password") String password);
}
