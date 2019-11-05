package com.kc345ws.bridge;

//充当桥接作用,为抽象层次
public abstract class Phone {
    //组合品牌
    private IBrand iBrand;

    public Phone(IBrand iBrand){
        this.iBrand = iBrand;
    }

    protected void open(){
        this.iBrand.open();
    }

    protected  void call(){
        this.iBrand.call();
    }
}
