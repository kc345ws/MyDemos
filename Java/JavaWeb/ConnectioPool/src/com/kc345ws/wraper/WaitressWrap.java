package com.kc345ws.wraper;

/*
* 装饰者类
* */
public class WaitressWrap implements Waiter{
    Waiter waiter = null;
    public WaitressWrap(Waiter waiter){
        this.waiter = waiter;
    }

    @Override
    public void servie() {
        System.out.println("被装饰");
        waiter.servie();
    }
}
