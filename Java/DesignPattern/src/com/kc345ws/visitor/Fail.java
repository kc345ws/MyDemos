package com.kc345ws.visitor;

//给出失败评价
public class Fail extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男性给出失败评价");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女性给出失败评价");
    }
}
