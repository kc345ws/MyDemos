package com.kc345ws.observer;

public class Client {
    public static void main(String[]args){
        WeatherData weatherData = new WeatherData();

        //创建观察者
        weatherData.registerObserver(new CurrentConditions());

        //通知所有观察者
        weatherData.setData(30,100,40);
        weatherData.notifyObervers();

        weatherData.registerObserver(new BaiduSite());
        weatherData.setData(40,123,54);
        weatherData.notifyObervers();
    }
}
