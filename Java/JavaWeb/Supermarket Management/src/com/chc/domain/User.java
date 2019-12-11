package com.chc.domain;

public class User  {
    private int id;
    private String name;
    private String pwd;
    private int identity;//身份 0售货员 1管理者
    static class Identity{
        static final int SALER = 0;
        static final int MANAGER = 1;
    }

    public User(String id, String name, String identity){

    }

    public User(int id , String name , String pwd , int identity){
        this.id = id;
        this.name = name;
        this.pwd = pwd;
        this.identity =identity;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }
}
