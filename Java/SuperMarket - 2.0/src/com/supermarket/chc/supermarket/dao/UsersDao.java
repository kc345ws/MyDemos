package com.supermarket.chc.supermarket.dao;

import com.supermarket.chc.supermarket.entity.Users;
import com.supermarket.chc.supermarket.entity.UsersView;
import com.supermarket.chc.supermarket.util.Page;

import java.util.List;

public interface UsersDao {
int login(Users user);//用户登录
int modifypwd(Users user, String newPwd);//修改密码
List<UsersView> list();//查询所有用户
Users findById(int id);//根据id查找用户
    Users findByAcc(String acc);//根据账号查找
List<UsersView> findByName(String name);//根据用户名查找用户
List<UsersView> getPageInfo(Page pages);
int update(Users user);//更新用户信息
int del(int id);//删除用户
int add(Users user);//添加
}
