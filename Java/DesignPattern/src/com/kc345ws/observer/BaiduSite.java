package com.kc345ws.observer;

//扩展的观察者
public class BaiduSite implements Observer {
    float temperature;
    float presure;
    float humdiity;
    @Override
    public void update(float temperature, float pressure, float humdiity) {
        this.temperature = temperature;
        this.presure = pressure;
        this.humdiity = humdiity;
        display();
    }

    @Override
    public void display() {
        System.out.println("百度今日天气数据");
        System.out.println("气温:"+temperature);
        System.out.println("气压:"+presure);
        System.out.println("湿度:"+humdiity);
    }
}
