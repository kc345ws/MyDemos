package com.kc345ws.reflectdemo;

public class Client {
    public static void main(String[]args){
        System.out.println("---------------reflectInstance()---------------------");
        ReflectClass.reflectInstance();
        System.out.println("---------------reflectPrivateConsturctor()---------------------");
        ReflectClass.reflectPrivateConsturctor();
        System.out.println("---------------reflectPrivateField()---------------------");
        ReflectClass.reflectPrivateField();
        System.out.println("---------------reflectPrivateMethod()---------------------");
        ReflectClass.reflectPrivateMethod();
    }
}
