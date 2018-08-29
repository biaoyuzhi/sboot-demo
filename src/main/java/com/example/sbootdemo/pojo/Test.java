package com.example.sbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wuzh on 2018/8/22.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Test {

    private int id;
    private String sex;

}
