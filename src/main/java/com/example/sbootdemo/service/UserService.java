package com.example.sbootdemo.service;

import com.example.sbootdemo.mapper.UserMapper;
import com.example.sbootdemo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public User findUserById(int id){
        User user = null;
        try {
            user = userMapper.findUserById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
