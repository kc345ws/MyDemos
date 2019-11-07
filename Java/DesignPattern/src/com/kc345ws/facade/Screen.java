package com.kc345ws.facade;

import java.awt.desktop.SystemSleepEvent;

public class Screen {
    private static Screen instance = new Screen();

    private Screen(){}

    public static Screen getInstance(){
        return instance;
    }

    public void on(){
        System.out.println("屏幕开启");
    }

    public void off(){
        System.out.println("屏幕关闭");
    }

    public void work(){
        System.out.println("屏幕工作中");
    }
}
