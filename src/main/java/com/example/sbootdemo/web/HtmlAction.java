package com.example.sbootdemo.web;

import com.example.sbootdemo.interceptor.NeedLogin;
import com.example.sbootdemo.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by wuzh on 2019/9/12.
 * Describe：展示html页面相关接口
 */
@Controller
public class HtmlAction {
    @GetMapping
    public String welcomeIndex(Model model){
        int[] data = {10,23,65,16,97,32};
        model.addAttribute("data",data);
        return "index";
    }

    @NeedLogin
    @GetMapping("/login")
    public String loginIndex(Model model){
        int[] data = {10,23,65,16,97,32};
        model.addAttribute("data",data);
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user){     // 这里可以直接使用User对象来接收前端传过来的表单数据，根据表单的name属性名称一一对应
        System.out.println(user.toString());
        // 如果不引入模板依赖，templates下的html文件是访问不到的，会抛出405等异常
        return "index";
    }
}
