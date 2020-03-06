package com.kc345ws.JSP.dao;

//定义用户表的一些操作
public interface UserDao {

    /*
    *
    * @return true:登陆成功 , false:登陆失败
    * */
    boolean Login(String username , String password);
}
