package com.kc345ws.principle.singleresponsibility;

//单一职责
public class SingleResponsibiliey01 {
    public static void main(String[]args){
        Vehicle vehicle = new Vehicle();
        vehicle.run("汽车");
        vehicle.run("飞机");
    }
}

//交通工具类
//违反单一职责
class Vehicle{
    public void run(String vehicle){
        System.out.println(vehicle + "在公路跑");
    }
}


