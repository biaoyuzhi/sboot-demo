package com.example.sbootdemo.mapper;

import com.example.sbootdemo.pojo.Person;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.mapping.StatementType;

/**
 * Created by wuzh on 2018/9/25.
 */
@Mapper
public interface PersonMapper {
    // 返回影响行数，并且将新生成的id值放入入参的对象person.id中
    @Insert("insert into person(name,password) values(#{person.name},#{person.password})")
    @SelectKey(statement="select LAST_INSERT_ID()", keyProperty="person.id", before=false, statementType= StatementType.STATEMENT,resultType=Long.class)
    Long addPerson(@Param("person") Person person);
}
