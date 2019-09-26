package com.example.sbootdemo.iterceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wuzh on 2019/9/26.
 * Describe：自定义拦截器LoginFilter，需要实现HandlerInterceptor接口
 * 此处实现对自定义注解@NeedLogin的使用
 */
public class LoginFilter implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            System.out.println("当前操作handler不为HandlerMethod=" + handler.getClass().getName());
            return false;
        }
        //获得经过拦截器的方法
        HandlerMethod handlerMethod=(HandlerMethod) handler;

        String methodName  = handlerMethod.getMethod().getName();
        //判断该方法上是否有相应的注解信息
//        boolean present = handlerMethod.getMethod().isAnnotationPresent(NeedLogin.class);
        //通过反射的getAnnotation方法获得其方法上的指定的NeedLogin类型的注解。
        NeedLogin myAnno= handlerMethod.getMethod().getAnnotation(NeedLogin.class);
        if (myAnno != null) {  //如果获得的注解不为空的话，说明此方法需要权限才可以执行。
            System.out.println("当前操作需要登录");
            //再看其session 的属性里是否有关于LOGIN属性的信息，若没有，则拦截此方法，不执行方法的操作
            if (request.getSession().getAttribute("LOGIN") == null) {
                System.out.println("当前操作" + methodName + "用户未登录,ip=" + request.getRemoteAddr());
                return false;
            }
            return true;
        }
        System.out.println("当前操作不需要登录，可以直接访问");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
