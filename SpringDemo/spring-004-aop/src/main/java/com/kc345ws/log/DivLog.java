package com.kc345ws.log;

//自定义切面类
public class DivLog {
    public void before(){
        System.out.println("before之前");
    }

    public void after(){
        System.out.println("after之后");
    }
}
