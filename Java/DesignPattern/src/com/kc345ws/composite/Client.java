package com.kc345ws.composite;

public class Client {
    public static void main(String[]args){
        //从大到小
        OrganizationComponent university =  new University("清华大学","一所大学");


        //学院
        OrganizationComponent cs = new College("计算机学院","计算机学院");
        OrganizationComponent ie = new College("信息工程学院","信息工程学院");

        university.add(cs);
        university.add(ie);
        //添加系
        cs.add(new Department("软件学院","软件工程"));
        ie.add(new Department("网络工程","网络工程"));

        //university.print();
        cs.print();
    }
}
