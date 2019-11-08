package com.kc345ws.visitor;

//给出成功评价
public class Success extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男性给出成功评价");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女性给出成功评价");
    }
}
