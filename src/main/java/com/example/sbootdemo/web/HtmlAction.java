package com.example.sbootdemo.web;

import com.example.sbootdemo.iterceptor.NeedLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
