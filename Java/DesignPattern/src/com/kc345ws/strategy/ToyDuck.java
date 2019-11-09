package com.kc345ws.strategy;

public class ToyDuck extends Duck {
    public ToyDuck(){
        this.flyBehaviour = new NoFlyBehaviour();
    }
}
