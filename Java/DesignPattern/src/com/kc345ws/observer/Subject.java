package com.kc345ws.observer;

//让WeatherData实现
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObervers();
}
