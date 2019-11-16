package com.example.sbootdemo.dao;

import com.example.sbootdemo.pojo.SummaryRequirements;
import com.example.sbootdemo.pojo.SummaryRequirementsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

//添加注解，将该对象注入Spring容器
@Mapper
public interface SummaryRequirementsMapper {
    int countByExample(SummaryRequirementsExample example);

    int deleteByExample(SummaryRequirementsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SummaryRequirements record);

    int insertSelective(SummaryRequirements record);

    List<SummaryRequirements> selectByExample(SummaryRequirementsExample example);

    SummaryRequirements selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SummaryRequirements record, @Param("example") SummaryRequirementsExample example);

    int updateByExample(@Param("record") SummaryRequirements record, @Param("example") SummaryRequirementsExample example);

    int updateByPrimaryKeySelective(SummaryRequirements record);

    int updateByPrimaryKey(SummaryRequirements record);
}