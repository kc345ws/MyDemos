package com.kc345ws.strategy;

public class NoFlyBehaviour implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("不会飞");
    }
}
