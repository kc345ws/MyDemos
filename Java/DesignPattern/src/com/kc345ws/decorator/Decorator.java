package com.kc345ws.decorator;

//装饰者
public class Decorator extends Drink{
    private Drink obj;

    @Override
    public float cost() {
        return super.getPrice() + obj.cost();//调料自己的价格加上单品咖啡的价格
    }

    public Decorator(Drink drink){
        this.obj = drink;//聚合关系
    }

    @Override
    public String getDes() {
        //obj.getDes()被装饰者的信息
        return super.getDes() +" " + getPrice() +" "+"&&"+obj.getDes();
    }
}
