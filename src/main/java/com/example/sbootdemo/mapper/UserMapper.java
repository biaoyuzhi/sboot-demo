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

    // Mybatis 有则更新，无则插入的实现。这里的id具有唯一特性。ON DUPLICATE KEY UPDATE xxx：当唯一键重复的时候，更新xxx信息。
    @Insert("insert into user(id,name,password) values(#{user.id},#{user.name},#{user.password}) ON DUPLICATE KEY UPDATE name = #{user.name}, password = #{user.password}")
    void addOrUpdateUser(@Param("user") User user);
}
