package com.kc345ws.decorator;

public class CoffeeBar {
    public static void main(String [] args){
        //1.点一份单品咖啡
        Drink drink = new LongBlack();
        System.out.println("单品咖啡价格 = " + drink.cost());
        System.out.println("单品咖啡描述 =" + drink.getDes());
        //2.加入一份牛奶
        drink = new Milk(drink);//用牛奶包裹咖啡
        System.out.println("加入一份牛奶后咖啡价格 = " + drink.cost());
        System.out.println("加入一份牛奶后咖啡描述 =" + drink.getDes());
        //3.加入一份巧克力
        drink = new Chocolate(drink);//用巧克力包裹牛奶咖啡
        System.out.println("加入一份牛奶巧克力后咖啡价格 = " + drink.cost());
        System.out.println("加入一份牛奶巧克力后咖啡描述 =" + drink.getDes());
        //4.再加入一份巧克力
        drink = new Chocolate(drink);//用巧克力包裹牛奶巧克力咖啡
        System.out.println("加入一份牛奶2份巧克力再后咖啡价格 = " + drink.cost());
        System.out.println("加入一份牛奶2份巧克力后咖啡描述 =" + drink.getDes());
    }
}
