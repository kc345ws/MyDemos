package com.kc345ws.prototype;

//原型模式
public class Sheep implements Cloneable{
    private String name;
    private int id;
    public Sheep(String name , int id){
        this.name = name;
        this.id = id;
    }

    @Override
    protected Object clone(){

        Sheep sheep = null;
        try {
           sheep = (Sheep) super.clone();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return sheep;
    }

    @Override
    public String toString() {
        String str = "name = " + name + " id = " + id;

        return str;
    }
}
