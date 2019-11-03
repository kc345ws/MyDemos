package com.kc345ws.principle.liskov;

public class Liskov {
    public static void main(String[] args){
        //因为B类不再继承A类，因此调用者，不会再认为fun1时减法
        B b = new B();
        //调用完成的功能会很明确
        System.out.println("11+3="+b.fun1(11,3));

        //使用组合仍然可以使用A类相关方法
        System.out.println("11-3="+b.fun2(11,3));
    }
}

//创建一个更加基础的基类
class Base{
    //把更加基础的方法和成员写到Base类
}

class A extends Base{
    public int fun1(int num1 ,int num2){
        return num1 - num2;
    }
}

class B extends Base{
    //如果B使用了A的方法，使用组合关系
    private A a = new A();

    public int fun1(int num1, int num2){
        return num1 + num2;
    }

    public int fun2(int num1, int num2){
        return  a.fun1(num1,num2);
    }
}
