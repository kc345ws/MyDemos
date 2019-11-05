package com.kc345ws.bridge;

public class Vivo implements IBrand {
    @Override
    public void open() {
        System.out.println("Vivo手机开机");
    }

    @Override
    public void call() {
        System.out.println("Vivo手机打电话");
    }
}
