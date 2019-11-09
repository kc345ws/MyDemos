package com.kc345ws.strategy;

public class PekingDuck extends Duck {
    public PekingDuck(){
        this.flyBehaviour = new BadFlyBehaviour();
    }
}
