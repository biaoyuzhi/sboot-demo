package com.example.sbootdemo.web;

import com.example.sbootdemo.pojo.User;
import com.example.sbootdemo.service.QueueService;
import com.example.sbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

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
    private QueueService queueService;

    @GetMapping("/hello")
    public User index() {
        System.out.println("+++++++++++" + port);
        User user = userService.findUserById(1);
        return user;
    }

    @GetMapping("/getQueue")
    public void getQueue(){
        new Thread("wuzh"){
            @Override
            public void run() {
                synchronized (HelloAction.class) {
                    try {
                        queueService.putUser(User.builder().id(1).name("wuzh").password("123456").build());
                        this.sleep(10);
                        User user = queueService.pollUser("router");
                        System.err.println(LocalTime.now() + "-----------" + Thread.currentThread().getName() + "取得队列中的对象为：" + user.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

        new Thread("hh"){
            @Override
            public void run() {
                synchronized (HelloAction.class) {
                    try {
                        queueService.putUser(User.builder().id(2).name("hh").password("123hh").build());
                        this.sleep(10);
                        User user = queueService.pollUser("router");
                        System.err.println(LocalTime.now() + "-----------" + Thread.currentThread().getName() + "取得队列中的对象为：" + user.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
