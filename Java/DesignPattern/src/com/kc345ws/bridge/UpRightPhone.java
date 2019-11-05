package com.kc345ws.bridge;

public class UpRightPhone extends Phone {
    public UpRightPhone(IBrand iBrand){
        super(iBrand);
    }

    @Override
    protected void open() {
        super.open();
        System.out.println("直立式手机");
    }

    @Override
    protected void call() {
        super.call();
        System.out.println("直立式手机");
    }
}
