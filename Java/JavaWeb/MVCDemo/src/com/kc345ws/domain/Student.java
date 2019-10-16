package com.kc345ws.domain;

import java.util.Date;

/*
* 针对数据库数据的封装
* */
public class Student {
    private int id;
    private String name;
    private String sex;
    private String telnum;
    private Date birthday;
    private String hoby;
    private String info;

    public Student(){}
    public Student(String name , String sex , String telnum , Date birthday,String hoby,String info){
        this.name = name;
        this.sex = sex;
        this.telnum = telnum;
        this.birthday = birthday;
        this.hoby = hoby;
        this.info = info;
    }

    public Student(int id , String name , String sex , String telnum , Date birthday,String hoby,String info){
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.telnum = telnum;
        this.birthday = birthday;
        this.hoby = hoby;
        this.info = info;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelnum() {
        return telnum;
    }

    public void setTelnum(String telnum) {
        this.telnum = telnum;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getHoby() {
        return hoby;
    }

    public void setHoby(String hoby) {
        this.hoby = hoby;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
