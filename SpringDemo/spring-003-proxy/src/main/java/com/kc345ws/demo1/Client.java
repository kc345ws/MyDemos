package com.kc345ws.demo1;

public class Client {
    public static void main(String[]args){
//        直接找房东租房子
//        HouseOwner houseOwner = new HouseOwner();
//        houseOwner.rent();

//        中介帮助房东出租房子
        HouseOwner houseOwner = new HouseOwner();
        Proxy proxy = new Proxy(houseOwner);
        proxy.rent();
    }
}
