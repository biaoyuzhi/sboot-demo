package com.example.sbootdemo.dao;

import com.example.sbootdemo.pojo.ReservationOrder;
import com.example.sbootdemo.pojo.ReservationOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//添加注解，将该对象注入Spring容器
@Mapper
public interface ReservationOrderMapper {
    int countByExample(ReservationOrderExample example);

    int deleteByExample(ReservationOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReservationOrder record);

    int insertSelective(ReservationOrder record);

    List<ReservationOrder> selectByExample(ReservationOrderExample example);

    ReservationOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ReservationOrder record, @Param("example") ReservationOrderExample example);

    int updateByExample(@Param("record") ReservationOrder record, @Param("example") ReservationOrderExample example);

    int updateByPrimaryKeySelective(ReservationOrder record);

    int updateByPrimaryKey(ReservationOrder record);
}