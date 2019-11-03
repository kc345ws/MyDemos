package com.kc345ws.factory.absfactory.order;

import com.kc345ws.factory.factorymethod.pizza.Pizza;

public interface AbsFactory {
    Pizza createPizza(String ordertype);
}
