package com.kc345ws.factory.factorymethod.pizza;

public abstract class Pizza {
    protected String name;
    public void setName(String name){
        this.name = name;
    }


    public abstract void prepare();
    public abstract void sosht();
}
