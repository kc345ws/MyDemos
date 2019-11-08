package com.kc345ws.visitor;

public class Wait extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println("男性给出待定评价");
    }

    @Override
    public void getWomanResult(Woman woman) {
        System.out.println("女性给出待定评价");
    }
}
