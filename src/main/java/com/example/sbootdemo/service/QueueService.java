package com.example.sbootdemo.service;

import com.example.sbootdemo.pojo.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by wuzh on 2018/8/12 0012.
 */
@Service
public class QueueService {
    static final ConcurrentHashMap<String,LinkedBlockingQueue<User>> map = new ConcurrentHashMap<>(1024);

    public void putUser(User user) throws InterruptedException {
        LinkedBlockingQueue<User> blockingQueue = map.get("router");
        if (blockingQueue==null){
            blockingQueue = new LinkedBlockingQueue<User>(50);
        }
        blockingQueue.put(user);
        map.put("router",blockingQueue);
    }

    public User pollUser(String router) throws InterruptedException {
        LinkedBlockingQueue<User> blockingQueue = map.get(router);
        if (blockingQueue==null){
            blockingQueue = new LinkedBlockingQueue<User>(50);
            map.put("router",blockingQueue);
            return null;
        }
        if (blockingQueue.size()<1){
            User user = User.builder().id(10).name("xxx").password("123").build();
            return user;
        }
        return blockingQueue.poll(5, TimeUnit.SECONDS);
    }
}
