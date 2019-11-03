package com.kc345ws.principle.singleresponsibility;

public class SingleResponsibiliey02 {
    public static void main(String []args){

    }
}

/*
* 1.遵守单一原则
* 2.
* */
class RoadVehicle{
    public void run(String roadvehicle){
        System.out.println(roadvehicle+"公路跑");
    }
}

class WaterVechicle{
    public void run(String roadvehicle){
        System.out.println(roadvehicle+"水里跑");
    }
}
