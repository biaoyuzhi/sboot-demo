package com.example.sbootdemo.service;

import com.example.sbootdemo.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by wuzh on 2018/8/22.
 */
@Service
public class TestService {
    @Autowired
    private TestMapper mapper;
    public void add(int id, String sex) {
        mapper.add(id,sex);
    }
}
