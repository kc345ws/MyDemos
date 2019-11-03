package com.kc345ws.factory.simplefactory.order;

import com.kc345ws.factory.simplefactory.SimpleFactory;

public class PizzaStore {
    public static void main(String[]args){
        new OrderPizza(new SimpleFactory());

    }
}
