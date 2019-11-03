package com.kc345ws.singleton.type7;

//静态内部类
public class Singleton07 {
    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton == singleton1);
    }
}

//解决了线程安全和懒加载问题
//同时保证了效率
class Singleton{
    private Singleton(){}

    private static class SingletonInstance{
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance(){
        return SingletonInstance.INSTANCE;
    }
}


