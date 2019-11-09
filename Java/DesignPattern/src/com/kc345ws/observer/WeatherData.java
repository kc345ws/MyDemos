package com.kc345ws.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{
    //温度 气压 湿度
    private float temperature;
    private float pressure;
    private float humidity;
    //private CurrentConditions currentConditions;
    //观察者集合
    private List<Observer> observers;

    public WeatherData(){
        observers = new ArrayList<>();
    }

    public float getTemperature(){
        return temperature;
    }

    public float getPressure(){
        return pressure;
    }

    public float getHumidity(){
        return humidity;
    }

    public void dataChange(){
        //数据更新了
        notifyObervers();
    }

    public void setData(float temperature,float pressure,float humidity){
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);//注册一个观察者
    }

    @Override
    public void removeObserver(Observer o) {
        if(observers.contains(o)){
            observers.remove(o);
        }
    }

    @Override
    public void notifyObervers() {
        for(var item:observers){
            item.update(temperature,pressure,humidity);//更新所有观察者的数据
        }
    }
}
