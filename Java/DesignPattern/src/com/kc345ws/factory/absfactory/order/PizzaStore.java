package com.kc345ws.factory.absfactory.order;



import com.kc345ws.factory.factorymethod.pizza.Pizza;

import java.util.Scanner;

public class PizzaStore {
    public static void main(String[] args){
        final OrderPizza orderPizza = new OrderPizza();


        String local ="";
        String ordertype ="";
        Scanner scanner = new Scanner(System.in);


        while(true){
            System.out.println("请输入Pizza地区");
            local = scanner.next();
            System.out.println("请输入Pizza种类");
            ordertype = scanner.next();
            Pizza pizza = null;

            if(local.equals("北京")){
                orderPizza.setFactory("北京");

                if(ordertype.equals("奶酪")){
                    pizza = orderPizza.getFactory().createPizza("奶酪");


                }else if(ordertype.equals("胡椒")){
                    pizza = orderPizza.getFactory().createPizza("胡椒");
                }

            }else if(local.equals("伦敦")){
                orderPizza.setFactory("伦敦");

                if(ordertype.equals("奶酪")){
                    pizza = orderPizza.getFactory().createPizza("奶酪");


                }else if(ordertype.equals("胡椒")){
                    pizza = orderPizza.getFactory().createPizza("胡椒");
                }
            }

            if(pizza == null){
                System.out.println("没有该种Pizza");
            }

            }
    }
}
