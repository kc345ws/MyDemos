package com.kc345ws.composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {
    //添加department
    List<OrganizationComponent> organizationComponents = new ArrayList<>();


    public College(String name, String des) {
        super(name, des);
    }

    @Override
    protected void print() {

        System.out.println("校园名称名称:" + getName());
        for(var item : organizationComponents){
            item.print();
        }
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getDes() {
        return super.getDes();
    }

    @Override
    protected void add(OrganizationComponent organizationComponent) {
        //super.add(organizationComponent);
        organizationComponents.add(organizationComponent);

        //实际业务中university和college业务逻辑可能不完全相同
    }

    @Override
    protected void remove(OrganizationComponent organizationComponent) {
        organizationComponent.remove(organizationComponent);
    }


}
