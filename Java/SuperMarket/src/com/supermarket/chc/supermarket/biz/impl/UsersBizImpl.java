package com.supermarket.chc.supermarket.biz.impl;

import com.supermarket.chc.supermarket.biz.UsersBiz;
import com.supermarket.chc.supermarket.dao.impl.UsersDaoImpl;
import com.supermarket.chc.supermarket.entity.Users;
import com.supermarket.chc.supermarket.entity.UsersView;
import com.supermarket.chc.supermarket.util.Page;

import java.util.List;

public class UsersBizImpl implements UsersBiz {
	
 private UsersDaoImpl dao=new UsersDaoImpl();
	@Override
	public int login(Users user) {
	return dao.login(user);
	}

	@Override
	public int modifypwd(Users user,String newPwd) {
	return dao.modifypwd(user, newPwd);
	}

	@Override
	public List<UsersView> list() {
	return dao.list();
	}

	@Override
	public Users findById(int id) {
	return dao.findById(id);
	}

	@Override
	public Users findByAcc(String acc) {
		return dao.findByAcc(acc);
	}

	@Override
	public List<UsersView> getPageInfo(Page pages) {
	return dao.getPageInfo(pages);
	}

	@Override
	public int update(Users user) {
	return dao.update(user);
	}

	@Override
	public int del(int id) {
	return dao.del(id);
	}

	@Override
	public int add(Users user) {
	return dao.add(user);
	}

	@Override
	public List<UsersView> findByName(String name) {
	return dao.findByName(name);
	}

}
