package com.example.sbootdemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by wuzh on 2018/9/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    private Long id;
    private String name;
    private String password;

    public Person(String name,String password){
        this.name = name;
        this.password = password;
    }
}
