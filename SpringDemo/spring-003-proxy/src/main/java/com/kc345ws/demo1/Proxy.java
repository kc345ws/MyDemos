package com.kc345ws.demo1;

//中介代理对象
public class Proxy implements Rent{
    private HouseOwner houseOwner;
    public Proxy(){}
    public Proxy(HouseOwner houseOwner){
        this.houseOwner = houseOwner;
    }


    public void rent() {
        seeHouse();
        houseOwner.rent();
        sign();
    }

    private void seeHouse(){
        System.out.println("中介带客户看房子");
    }

    private void sign(){
        System.out.println("中介帮房东签订合同");
    }
}
