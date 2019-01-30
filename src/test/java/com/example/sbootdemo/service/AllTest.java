package com.example.sbootdemo.service;

import com.example.sbootdemo.util.CommonUtils;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by wuzh on 2018/11/7.
 */
public class AllTest {

    @Test
    public void visit() throws Exception {
        double balance = CommonUtils.rmbCent2Round(100, 91);
        if (balance<0) {
            System.out.println("余额不足");
        }else {
            System.out.println(balance);
        }
    }

}