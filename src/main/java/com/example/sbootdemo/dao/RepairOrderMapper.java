package com.example.sbootdemo.dao;

import com.example.sbootdemo.pojo.RepairOrder;
import com.example.sbootdemo.pojo.RepairOrderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//添加注解，将该对象注入Spring容器
@Mapper
public interface RepairOrderMapper {
    int countByExample(RepairOrderExample example);

    int deleteByExample(RepairOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RepairOrder record);

    int insertSelective(RepairOrder record);

    List<RepairOrder> selectByExample(RepairOrderExample example);

    RepairOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RepairOrder record, @Param("example") RepairOrderExample example);

    int updateByExample(@Param("record") RepairOrder record, @Param("example") RepairOrderExample example);

    int updateByPrimaryKeySelective(RepairOrder record);

    int updateByPrimaryKey(RepairOrder record);
}