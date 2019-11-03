package com.kc345ws.principle.inversion;

/*
* 依赖倒转原则
* */
public class Inversion01 {
    public static void main(String[] args){
        Person person = new Person();
        person.receive(new Email());
        person.receive(new Weixin());
    }
}

interface IReceive{
    public String getInfo();
}

class Email implements IReceive{

    @Override
    public String getInfo() {
        return "短信信息";
    }
}

class Weixin implements  IReceive{

    @Override
    public String getInfo() {
        return "微信信息";
    }
}

class Person{
    public void receive(IReceive iReceive){
        System.out.println(iReceive.getInfo());
    }
}
