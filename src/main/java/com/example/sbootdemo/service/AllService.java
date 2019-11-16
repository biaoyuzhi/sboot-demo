package com.example.sbootdemo.service;

import com.example.sbootdemo.dao.BookMapper;
import com.example.sbootdemo.dao.PersonMapper;
import com.example.sbootdemo.pojo.Book;
import com.example.sbootdemo.pojo.Person;
import com.example.sbootdemo.pojo.PersonExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by wuzh on 2019/11/16.
 * Describe:
 */
@Service
public class AllService {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private PersonMapper personMapper;

    public Book selectByPrimaryKey(int id){
        return bookMapper.selectByPrimaryKey(id);
    }

    /**
     * mybatis中example类的使用
     * 理论上通过example类可以构造你想到的任何筛选条件
     *
     * @return
     */
    public List<Person> selectByExample(){
        //实例化example对象
        PersonExample example = new PersonExample();
        //向example对象填充查询条件
        example.setOrderByClause("id desc"); //设置按id降序
        example.createCriteria().andNameLike("%wu%");   //设置name字段的模糊查询
        //使用selectByExample方法查询结果
        return personMapper.selectByExample(example);
    }
}
