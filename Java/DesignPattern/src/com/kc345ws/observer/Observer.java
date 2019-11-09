package com.kc345ws.observer;

//观察者接口
public interface Observer {
    void update(float temperature,float pressure,float humdiity);//更新数据
    void display();
}
