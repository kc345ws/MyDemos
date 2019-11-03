package com.kc345ws.factory.simplefactory;

import com.kc345ws.factory.simplefactory.pizza.ChinaPizza;
import com.kc345ws.factory.simplefactory.pizza.GreekPizza;
import com.kc345ws.factory.simplefactory.pizza.Pizza;

//简单工厂类
public class SimpleFactory {

    //根据orderType返回对应的Pizza对象
    public Pizza createPizza(String orderType){
        Pizza pizza = null;
        System.out.println("使用简单工厂模式");


        if(orderType.equals("greek")){
            pizza = new GreekPizza();
            pizza.setName("希腊披萨");
        }else if(orderType.equals("china")){
            pizza = new ChinaPizza();
            pizza.setName("中国披萨");
        }
        //pizza.prepare();
        //pizza.make();

        return pizza;
    }
}
