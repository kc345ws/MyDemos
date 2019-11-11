package com.kc345ws.decorator;

//Component主体
public abstract class Drink {
    public String des;//描述
    private float price = 0.0f;//价格

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    //计算费用的抽象方法
    //子类实现
    public abstract float cost();
}
public class Adapter extends Adaptee implements Target
{
    public void request()
    {
        specificRequest();
    }
}

public class Adapter extends Target
{
    private Adaptee adaptee;
    public Adapter(Adaptee adaptee)
    {
        this.adaptee=adaptee;
    }
    public void request()
    {
        adaptee.specificRequest();
    }
}

