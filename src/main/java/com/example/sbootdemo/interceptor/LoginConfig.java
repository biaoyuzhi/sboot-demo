package com.example.sbootdemo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by wuzh on 2019/9/26.
 * Describe：注册自定义拦截器LoginFilter，使自定义拦截器生效
 * SpringBoot2.X之前旧版本继承WebMvcConfigurationAdapter，SpringBoot2.X 新版本implements WebMvcConfigurer
 */
@Configuration
public class LoginConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor());
    }
}
