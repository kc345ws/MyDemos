package com.kc345ws.facade;

public class DVDPlayer {
    //使用单例模式 ,使用饿汉式
    private static DVDPlayer instance = new DVDPlayer();

    private DVDPlayer(){}

    public static DVDPlayer getInstance(){
        return  instance;
    }

    public void on(){
        System.out.println("DVD开启");
    }

    public void off(){
        System.out.println("DVD关闭");
    }

    public void play(){
        System.out.println("DVD开始播放");
    }

    public void pause(){
        System.out.println("DVD暂停");
    }
}
