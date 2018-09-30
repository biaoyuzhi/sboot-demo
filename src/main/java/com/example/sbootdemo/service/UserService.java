package com.example.sbootdemo.service;

import com.example.sbootdemo.common.Cache;
import com.example.sbootdemo.mapper.PersonMapper;
import com.example.sbootdemo.mapper.UserMapper;
import com.example.sbootdemo.pojo.Person;
import com.example.sbootdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PersonMapper personMapper;

    public User findUserById(int id){
        User user = null;
        try {
            user = userMapper.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * 此处数据库事务是成功的，启动类SbootDemoApplication上不需要加任何关于事务的注解。
     * @throws Exception
     */
    @Transactional
    public void transactionalTest() throws Exception{
        userMapper.modifyUser("1","666");
        int i = 2/0;
        userMapper.addUser("2","zhang","123");
    }

    /**
     * 此处测试逻辑上的事务，测试事务是不起作用的。因为下面每行代码可能是一个原子操作，但是整个逻辑不在一个原子操作中，所以无回滚、无事务可言。
     * @throws Exception
     */
    @Transactional
    public String translogicTest() throws Exception{
        Cache.putCache("a",new User(1,"aaa","123"));
        String cache = Cache.getCache("a").toString();
        System.err.println(cache);
        int i = 2/0;
        return Cache.removeCache("a").toString();
    }

    /**
     * 测试一个SQL语句
     * @param person
     * @return
     */
    public Long getIdTest(Person person){
        return personMapper.addPerson(person);
    }
}
