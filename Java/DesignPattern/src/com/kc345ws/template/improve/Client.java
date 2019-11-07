package com.kc345ws.template.improve;

public class Client {
    public static void main(String[] args){
        //制作红豆豆浆
        System.out.println("-----红豆豆浆----");
        SoyaMilk soyaMilk = new RedBeanSoyaMilk();
        soyaMilk.make();
        System.out.println("--------------------");
        System.out.println("-----花生豆浆----");
        SoyaMilk soyaMilk1 = new PeanuSoyaMilk();
        soyaMilk1.make();
        System.out.println("-----纯豆浆----");
        SoyaMilk soyaMilk2 = new PureSoyaMilk();
        soyaMilk2.make();
    }
}
