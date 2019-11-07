package com.kc345ws.composite;

import java.util.ArrayList;
import java.util.List;

//University 就是 Composite(非叶子结点)用于存储子部件 ,可以管理College
public class University extends OrganizationComponent {
    //添加college
    List<OrganizationComponent> organizationComponents = new ArrayList<>();

    public University(String name, String des) {
        super(name, des);
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        //super.add(organizationComponent);
        organizationComponents.add(organizationComponent);
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponent.remove(organizationComponent);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    //privat方法，输出University包含的所有院校
    @Override
    protected void print() {
        System.out.println("学校名称:" + getName());
        for(var item : organizationComponents){
            item.print();
        }
    }
}
