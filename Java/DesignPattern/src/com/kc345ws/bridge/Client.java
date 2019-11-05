package com.kc345ws.bridge;

public class Client {
    public static void main(String[] args){
        Phone phone = new FlodedPhone(new XiaoMi());
        Phone phone1 = new UpRightPhone(new XiaoMi());
        Phone phone2 = new FlodedPhone(new Vivo());
        Phone phone3 = new UpRightPhone(new Vivo());

        phone.open();
        phone.call();

        phone1.open();
        phone1.call();

        phone2.open();
        phone2.call();

        phone3.open();
        phone3.call();
    }
}
