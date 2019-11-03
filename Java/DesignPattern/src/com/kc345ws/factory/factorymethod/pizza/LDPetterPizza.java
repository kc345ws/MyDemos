package com.kc345ws.factory.factorymethod.pizza;

public class LDPetterPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("伦敦胡椒准备中...");
    }

    @Override
    public void sosht() {
        System.out.println(name+"制作中");
    }
}
