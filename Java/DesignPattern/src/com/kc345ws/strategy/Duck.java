package com.kc345ws.strategy;

public abstract class Duck {
    //聚合一个策略
    protected FlyBehaviour flyBehaviour;

    public void fly(){
        if(flyBehaviour!=null){
            flyBehaviour.fly();
        }
    }
}
