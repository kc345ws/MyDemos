package com.kc345ws.factory.factorymethod.order;

import com.kc345ws.factory.factorymethod.pizza.Pizza;

public abstract  class OrderPizza {
    public abstract Pizza createPizza(String ordertype);
}
