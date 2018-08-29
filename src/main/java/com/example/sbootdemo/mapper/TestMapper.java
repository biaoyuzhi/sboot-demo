package com.example.sbootdemo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by wuzh on 2018/8/22.
 */
@Mapper
public interface TestMapper {
    @Insert("insert into test values (#{id},#{sex})")
    void add(@Param("id") int id, @Param("sex") String sex);
}
