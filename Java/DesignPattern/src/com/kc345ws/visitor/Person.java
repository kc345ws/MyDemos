package com.kc345ws.visitor;

public abstract class Person {
    //提供方法，让访问者可以访问
    public abstract void accept(Action action);
}
