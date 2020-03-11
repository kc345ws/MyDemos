package com.kc345ws.Concurrency;

public class _007MyJoin {
    public static class A extends Thread{
        public void run(){
            System.out.println("这是A类");
        }

    }

    public static class B extends Thread{
        private A a;
        public B(A a) {this.a = a;}

        public void run(){
            try {
                a.join();//B优先保证A先执行完在执行B
                System.out.println("这是B类");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
