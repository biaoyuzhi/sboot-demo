package com.example.sbootdemo.mapper;

import com.example.sbootdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select id,name,password from user where id=#{id}")
    public User findUserById(Integer id);
}
