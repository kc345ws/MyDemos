package com.kc345ws.facade;

public class Projector {
    private static Projector instance = new Projector();

    private Projector(){}

    public static Projector getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("投影仪开启");
    }

    public void off(){
        System.out.println("投影仪关闭");
    }

    public void project(){
        System.out.println("投影仪投影中");
    }
}
