package com.example.sbootdemo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by wuzh on 2019/9/12.
 * Describe：
 */
@Controller
public class HtmlAction {
    @GetMapping
    public String welcomeIndex(Model model){
        int[] data = {10,23,65,16,97,32};
        model.addAttribute("data",data);
        return "index";
    }
}
