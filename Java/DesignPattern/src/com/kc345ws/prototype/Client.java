package com.kc345ws.prototype;

public class Client {
    public static void main(String[]args){
        Sheep sheep = new Sheep("倪司令",1);
        Sheep cloneSheep1 = (Sheep)sheep.clone();
        Sheep cloneSheep2 = (Sheep)sheep.clone();
        Sheep cloneSheep3 = (Sheep)sheep.clone();
        Sheep cloneSheep4 = (Sheep)sheep.clone();
        Sheep cloneSheep5 = (Sheep)sheep.clone();

        System.out.println("sheep = " + sheep.toString());
        System.out.println("cloneSheep2 = " + cloneSheep2.toString());
        System.out.println("cloneSheep1 = " + cloneSheep1.toString());
        System.out.println("cloneSheep3 = " + cloneSheep3.toString());
        System.out.println("cloneSheep4 = " + cloneSheep4.toString());
    }
}
