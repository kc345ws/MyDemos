package com.kc345ws.factory.factorymethod.pizza;

public class BJChessPizza extends Pizza {


    @Override
    public void prepare() {
        System.out.println("北京奶酪准备中...");
    }

    @Override
    public void sosht() {
        System.out.println(name+"制作中");
    }
}
