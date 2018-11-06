package com.example.sbootdemo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

/**
 * 定时任务测试
 * 1、启动类上加@EnableScheduling注解
 * 2、定时任务类如下，spring自带的，无需引入其它框架。注意cron后面的表达式不能写错，哪个是0，哪个是*
 */
@Component
public class ScheduledTask {
    /**
     * 每隔一分钟执行一次
     * @throws InterruptedException
     */
    @Scheduled(cron = "0 */1 * * * ?")
    public void execute(){
        System.err.println(LocalTime.now() +":定时任务开始了。。。");
    }
}
