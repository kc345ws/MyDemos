package com.kc345ws.factory.simplefactory.pizza;

public class ChinaPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("准备中国披萨");
    }


}
