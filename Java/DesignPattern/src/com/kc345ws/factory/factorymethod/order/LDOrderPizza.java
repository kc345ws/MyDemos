package com.kc345ws.factory.factorymethod.order;

import com.kc345ws.factory.factorymethod.pizza.*;

public class LDOrderPizza extends OrderPizza {
    @Override
    public Pizza createPizza(String ordertype) {
        Pizza pizza = null;

        if(ordertype.equals("奶酪")){
            pizza = new LDChessPizza();
            pizza.setName("伦敦奶酪");
        }else if(ordertype.equals("胡椒")){
            pizza = new LDPetterPizza();
            pizza.setName("伦敦胡椒");
        }

        if(pizza!=null){
            pizza.prepare();
            pizza.sosht();
        }

        return  pizza;
    }
}
