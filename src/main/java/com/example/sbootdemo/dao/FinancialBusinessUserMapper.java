package com.example.sbootdemo.dao;

import com.example.sbootdemo.pojo.FinancialBusinessUser;
import com.example.sbootdemo.pojo.FinancialBusinessUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//添加注解，将该对象注入Spring容器
@Mapper
public interface FinancialBusinessUserMapper {
    int countByExample(FinancialBusinessUserExample example);

    int deleteByExample(FinancialBusinessUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FinancialBusinessUser record);

    int insertSelective(FinancialBusinessUser record);

    List<FinancialBusinessUser> selectByExample(FinancialBusinessUserExample example);

    FinancialBusinessUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FinancialBusinessUser record, @Param("example") FinancialBusinessUserExample example);

    int updateByExample(@Param("record") FinancialBusinessUser record, @Param("example") FinancialBusinessUserExample example);

    int updateByPrimaryKeySelective(FinancialBusinessUser record);

    int updateByPrimaryKey(FinancialBusinessUser record);
}