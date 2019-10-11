package com.kc345ws.domain;

public class Student {
    private int id;
    private String name;
    private int age;
    private String adress;

    /*
    * 搞了半天终于搞清楚问题出在什么地方了,根据 JavaBeans 规范，属性的前
    * 两个字母不能是一大一小，或者是一小一大。开头字母要小写才行
    * */

    public Student(){}

    public Student(int id , String name , int age , String adress){
        this.id = id;
        this.name = name;
        this.age = age;
        this.adress = adress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
}
