package com.kc345ws.factory.simplefactory.pizza;

public abstract class Pizza {
    private String name;

    public void setName(String name){
        this.name = name;
    }

    public abstract void prepare();

    public void make(){
        System.out.println(name+"披萨制作中...");
    }
}
