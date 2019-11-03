package com.kc345ws.factory.factorymethod;

import com.kc345ws.factory.factorymethod.order.BJOrderPizza;
import com.kc345ws.factory.factorymethod.order.LDOrderPizza;
import com.kc345ws.factory.factorymethod.order.OrderPizza;
import com.kc345ws.factory.factorymethod.pizza.Pizza;

import java.util.Scanner;


//工厂方法模式使用方
public class FactoryMethod {
    public static void main(String[] args){
        String local ="";
        String ordertype ="";
        Scanner scanner = new Scanner(System.in);
        final BJOrderPizza bjOrderPizza = new BJOrderPizza();
        final LDOrderPizza ldOrderPizza = new LDOrderPizza();

        while(true){
            System.out.println("请输入Pizza地区");
            local = scanner.next();
            System.out.println("请输入Pizza种类");
            ordertype = scanner.next();
            Pizza pizza = null;

            if(local.equals("北京")){

                if(ordertype.equals("奶酪")){
                    pizza = bjOrderPizza.createPizza("奶酪");


                }else if(ordertype.equals("胡椒")){
                    pizza = bjOrderPizza.createPizza("胡椒");
                }

            }else if(local.equals("伦敦")){
                if(ordertype.equals("奶酪")){
                    pizza = ldOrderPizza.createPizza("奶酪");


                }else if(ordertype.equals("胡椒")){
                    pizza = ldOrderPizza.createPizza("胡椒");
                }
            }

            if(pizza == null){
                System.out.println("没有该种Pizza");
            }
        }
    }
}
