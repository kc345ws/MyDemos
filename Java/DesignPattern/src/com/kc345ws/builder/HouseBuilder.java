package com.kc345ws.builder;

//抽象建造者
public abstract class HouseBuilder {
    //组合一个产品类
    protected House house = new House();

    //将建造流程写好，抽象方法
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void buildRoofed();

    //建造房子，房子建造好后返回
    public House buildHouse(){
        return house;
    }

}
