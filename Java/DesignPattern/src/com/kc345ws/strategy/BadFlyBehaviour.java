package com.kc345ws.strategy;

public class BadFlyBehaviour implements FlyBehaviour {
    @Override
    public void fly() {
        System.out.println("飞行能力较差");
    }
}
