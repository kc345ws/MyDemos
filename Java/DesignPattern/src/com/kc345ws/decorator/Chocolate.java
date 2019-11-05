package com.kc345ws.decorator;

//巧克力调味品,具体的Decorator
public class Chocolate extends Decorator {
    public Chocolate(Drink drink) {
        super(drink);
        setDes("巧克力调味品");
        setPrice(3.0f);//调味品价格
    }


}
