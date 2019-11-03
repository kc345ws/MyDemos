package com.kc345ws.factory.factorymethod.pizza;

public class LDChessPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("伦敦奶酪准备中...");
    }

    @Override
    public void sosht() {
        System.out.println(name+"制作中");
    }
}
