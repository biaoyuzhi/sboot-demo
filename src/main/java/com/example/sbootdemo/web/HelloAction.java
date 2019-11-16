package com.example.sbootdemo.web;

import com.example.sbootdemo.pojo.Book;
import com.example.sbootdemo.pojo.Person;
import com.example.sbootdemo.pojo.User;
import com.example.sbootdemo.service.AllService;
import com.example.sbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    @Autowired
    private AllService allService;

    @GetMapping("/hello")
    public User index() {
        System.out.println("+++++++++++" + port);
        User user = userService.findUserById(1);
        return user;
    }

    @GetMapping("/get")
    public String getPojo(){
        Book book = allService.selectByPrimaryKey(1);
        return book.getName();
    }

    @GetMapping("/example")
    public Integer getExamplePojo(){
        List<Person> list = allService.selectByExample();
        for (Person person : list) {
            System.out.println(person.toString());
        }
        return list.size();
    }
}
