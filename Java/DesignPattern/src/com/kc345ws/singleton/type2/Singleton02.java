package com.kc345ws.singleton.type2;

//饿汉式(静态代码块)
public class Singleton02 {
    public static void main(String[] args){
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        System.out.println(singleton == singleton1);
        System.out.println(singleton);
        System.out.println(singleton1);
    }
}

//饿汉式(静态代码块)
class Singleton{
    //1.私有化构造器，类的外部不能new
    private Singleton(){}

    //2.本类内部创建一个静态实例
    private static Singleton instance;

    static {
        instance = new Singleton();
    }

    //3.对外通过getInstance获取
    public static Singleton getInstance(){
        return instance;
    }
}
