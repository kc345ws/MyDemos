package com.kc345ws.facade;

public class TheaterLight {
    private static TheaterLight instance = new TheaterLight();

    private TheaterLight(){}

    public static TheaterLight getInstance(){
        return instance;
    }

    public void dim(){
        System.out.println("灯光亮度调暗");
    }

    public void bright(){
        System.out.println("灯光亮度调亮");
    }
}
