package com.kc345ws.jdbc.dao;

//定义操作数据库的方法
public interface UserDao {
    //查询所有
    void findAll();

    //登陆
    void login(String user , String pwd);
}
