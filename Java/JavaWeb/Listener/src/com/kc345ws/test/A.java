package com.kc345ws.test;

//在1998年定义的类
public class A {
    public static void main(String[] args){
        A a = new A();
        a.print(new B());
    }


    public void print(PrintListener printListener){
        for (int i = 0 ; i < 10 ; i ++){
            System.out.println("在1998年开始执行");
            if (i == 5){
                printListener.print();;
            }
        }
    }
}
