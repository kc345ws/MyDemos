package com.kc345ws.visitor;

/*
* 1.这里使用了双分派，首先在客户端程序中，将具体的状态作为参数传递给Woman中(第一次分派)
* 2.然后Woman类调用作为参数的具体方法中的方法getWomanResult，同时将自己作为参数传入(第二次分派)
* */
public class Woman extends Person {
    @Override
    public void accept(Action action) {
        action.getWomanResult(this);
    }
}
