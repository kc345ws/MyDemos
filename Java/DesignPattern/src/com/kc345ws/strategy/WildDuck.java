package com.kc345ws.strategy;

public class WildDuck extends Duck {
    public WildDuck(){
        this.flyBehaviour = new GoodFlyBehaviour();
    }
}
