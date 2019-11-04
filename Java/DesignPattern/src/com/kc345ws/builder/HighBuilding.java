package com.kc345ws.builder;



public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println("高楼地基100米");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙20cm");
    }

    @Override
    public void buildRoofed() {
        System.out.println("高楼透明屋顶");
    }
}
