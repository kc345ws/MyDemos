package com.kc345ws.singleton.typr8;

//枚举方式
public class Singleton08 {
    public static void main(String[] args){
        Singleton singleton = Singleton.INSTANCE;
        Singleton singleton1 = Singleton.INSTANCE;

        System.out.println(singleton == singleton1);
        singleton.sayok();
    }
}

enum Singleton{
    INSTANCE;//属性
    public void sayok(){
        System.out.println("ok");
    }
}

