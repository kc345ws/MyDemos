package com.kc345ws.builder;

//动态指定制作流程,返回具体产品
public class HouseDirector {
    private HouseBuilder houseBuilder = null;

    //构造器传入
    public HouseDirector(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }

    //通过setter传入

    public HouseBuilder getHouseBuilder() {
        return houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    //如何处理建造房子流程，交给指挥者
    public House constructHouse(){
        houseBuilder.buildBasic();
        houseBuilder.buildWalls();
        houseBuilder.buildRoofed();

        return houseBuilder.buildHouse();
    }
}
