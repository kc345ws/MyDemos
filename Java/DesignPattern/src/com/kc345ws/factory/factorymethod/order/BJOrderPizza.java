package com.kc345ws.factory.factorymethod.order;

import com.kc345ws.factory.factorymethod.pizza.BJChessPizza;
import com.kc345ws.factory.factorymethod.pizza.BJPetterPizza;
import com.kc345ws.factory.factorymethod.pizza.Pizza;

public class BJOrderPizza extends OrderPizza {
    @Override
    public Pizza createPizza(String ordertype) {
        Pizza pizza = null;

        if(ordertype.equals("奶酪")){
            pizza = new BJChessPizza();
            pizza.setName("北京奶酪");
        }else if(ordertype.equals("胡椒")){
            pizza = new BJPetterPizza();
            pizza.setName("北京胡椒");
        }

        if(pizza!=null){
            pizza.prepare();
            pizza.sosht();
        }
        return  pizza;
    }
}
