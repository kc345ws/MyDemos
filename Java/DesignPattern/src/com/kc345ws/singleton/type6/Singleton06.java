package com.kc345ws.singleton.type6;

//双重检查
public class Singleton06 {
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

     private static volatile Singleton instance;//变量的修改会立刻写入内存

    public static Singleton getInstance(){
        if(instance == null){
            synchronized (Singleton.class){
                if(instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


