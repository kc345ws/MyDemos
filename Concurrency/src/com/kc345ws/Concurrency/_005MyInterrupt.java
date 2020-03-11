package com.kc345ws.Concurrency;

public class _005MyInterrupt extends  Thread {
    public void run(){
        try {
//            System.out.println("before sleep");
//            Thread.sleep(2000);
//            System.out.println("after sleep");
//            System.out.println("before interrupt");
//            Thread.interrupted();
//            System.out.println("after interrupt");

            Thread.interrupted();
            System.out.println("before sleep");
            Thread.sleep(2000);
            System.out.println("after sleep");
        } catch (InterruptedException e) {
            System.out.println("进入Catch");
            e.printStackTrace();
        }
    }
}
