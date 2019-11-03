package com.kc345ws.factory.simplefactory.order;

import com.kc345ws.factory.simplefactory.SimpleFactory;
import com.kc345ws.factory.simplefactory.pizza.Pizza;

import java.util.Scanner;

public class OrderPizza {
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    public OrderPizza(SimpleFactory simpleFactory){
        setFactory(simpleFactory);
    }

    public void setFactory(SimpleFactory simpleFactory){

        String ordertype;
        Scanner scanner = new Scanner(System.in);
        this.simpleFactory = simpleFactory;

        do {
            System.out.println("输入披萨种类");
            ordertype = scanner.next();

            //简单工厂封装了对象创建的细节
            pizza = this.simpleFactory.createPizza(ordertype);

            if(pizza !=null){
                //订购成功
                pizza.prepare();
                pizza.make();
            }else{
                System.out.println("订购失败");
            }
        }while (true);




    }
}
