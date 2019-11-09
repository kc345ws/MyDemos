package com.kc345ws.observer;

//具体观察者
public class CurrentConditions implements Observer{
    //温度 气压 湿度
    private float temperature;
    private float pressure;
    private float humidity;

    public void update(float temperature,float pressure,float humidity){
        this.temperature= temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    public void display(){
        System.out.println("气象站今日数据");
        System.out.println("今日温度:"+temperature);
        System.out.println("今日气压:"+pressure);
        System.out.println("今日湿度:"+humidity);
    }
}
