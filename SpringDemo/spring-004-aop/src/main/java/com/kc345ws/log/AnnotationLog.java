package com.kc345ws.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect//声明为切面
public class AnnotationLog {
    @Before("execution(* com.kc345ws.service.UserServiceImpl.*(..))")
    public void before(){
        System.out.println("执行前");
    }

    @After("execution(* com.kc345ws.service.UserServiceImpl.*(..))")
    public void after(){
        System.out.println("执行后");
    }

    @Around("execution(* com.kc345ws.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {//连接点
        System.out.println("环绕前");
        jp.proceed();//执行方法
        System.out.println("环绕后");
    }
}
