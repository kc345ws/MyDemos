package com.kc345ws.singleton.type3;

//单例模式 懒汉式(线程不安全)
public class Singletom03 {
    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton == singleton1);

    }
}

class Singleton{
    private static Singleton instance;
    private Singleton(){}


    //线程不安全,当使用此方法时才创建instance
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return  instance;
    }
}


