package com.kc345ws.visitor;

public class Man extends Person {
    @Override
    public void accept(Action action) {
        //接受访问者
        action.getManResult(this);
        //接受到访问者后，通过访问者的方法接受该男性的评价结果
    }
}
