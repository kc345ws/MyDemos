package com.kc345ws.composite;

public abstract class OrganizationComponent {
    private String name;
    private String des;//说明

    protected void add(OrganizationComponent organizationComponent){
        //叶子结点不需要重写该方法，所以不作为抽象方法
        throw new UnsupportedOperationException();
    }

    protected void remove(OrganizationComponent organizationComponent){
        //叶子结点不需要重写该方法，所以不作为抽象方法
        throw new UnsupportedOperationException();
    }

    public OrganizationComponent(String name,String des){
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }


    //打印方法
    protected abstract void print();
}
