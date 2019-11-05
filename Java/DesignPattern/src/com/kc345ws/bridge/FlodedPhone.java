package com.kc345ws.bridge;

public class FlodedPhone extends Phone {
    public FlodedPhone(IBrand iBrand) {
        super(iBrand);

    }

    public void open(){
        super.open();
        System.out.println("折叠样式手机");
    }

    public void call(){
        super.call();
        System.out.println("折叠样式手机");
    }
}
