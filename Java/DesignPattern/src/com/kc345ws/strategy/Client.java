package com.kc345ws.strategy;

public class Client {
    public static void main(String[]args){
        Duck duck = new PekingDuck();
        final WildDuck wildDuck = new WildDuck();
        final ToyDuck toyDuck = new ToyDuck();

        duck.fly();
        wildDuck.fly();
        toyDuck.fly();
    }
}
