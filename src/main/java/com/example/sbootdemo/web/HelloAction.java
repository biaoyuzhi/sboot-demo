package com.example.sbootdemo.web;

import com.example.sbootdemo.pojo.User;
import com.example.sbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: DHC
 * Date: 2018/3/2
 * Time: 14:02
 * Version:V1.0
 */
@RestController
public class HelloAction {
    @Value("${server.port}")
    private int port;
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public User index() {
        System.out.println("+++++++++++" + port);
        User user = userService.findUserById(1);
        return user;
    }
}
