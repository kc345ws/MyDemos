package com.kc345ws.composite;

public class Department extends OrganizationComponent {
    public Department(String name, String des) {
        super(name, des);
    }

    @Override
    protected void print() {
        System.out.println("系名称："+getName());
    }

    //不需要再重写add 和 remove 因为是叶子结点
}
