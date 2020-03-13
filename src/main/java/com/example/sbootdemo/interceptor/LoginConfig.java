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
    // 1、读取application.yml中的相应配置信息
//    @Value("${filter.urls}")
//    private String filterUrls;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginInterceptor());

        // 2、将不需要经过拦截器的url放入集合中
//        String[] split = filterUrls.split(",");
//        List<String> urls = Arrays.asList(split);
        // 3、调用排除在拦截器之外路径的方法excludePathPatterns(List)
        // 支持正则表达式：/api/v1/user/**      如果接口抛异常了，会进入/error接口，所以可以考虑将/error接口加入排除url集合中
//        registry.addInterceptor(new LoginInterceptor()).excludePathPatterns(urls);
    }
}
