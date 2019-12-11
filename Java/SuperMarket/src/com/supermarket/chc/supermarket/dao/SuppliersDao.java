package com.supermarket.chc.supermarket.dao;

import java.util.List;

import com.supermarket.chc.supermarket.entity.Suppliers;
import com.supermarket.chc.supermarket.util.Page;

public interface SuppliersDao {
	List<Suppliers> list();//查询所有用户
	Suppliers findById(int id);//根据id查找用户
	List<Suppliers> findByName(String name);//根据名称查找
	Suppliers findByIdForUpdate(int id);//根据id查找用户
	List<Suppliers> getPageInfo(Page pages);
	int update(Suppliers suppliers);//更新用户信息
	int del(int id);//删除用户
	int add(Suppliers suppliers);//添加
}
