package com.supermarket.chc.supermarket.biz.impl;

import java.util.List;

import com.supermarket.chc.supermarket.biz.OrdersBiz;
import com.supermarket.chc.supermarket.dao.OrdersDao;
import com.supermarket.chc.supermarket.dao.impl.OrdersDaoImpl;
import com.supermarket.chc.supermarket.entity.Orders;
import com.supermarket.chc.supermarket.entity.OrdersDetail;
import com.supermarket.chc.supermarket.entity.OrdersView;
import com.supermarket.chc.supermarket.entity.Suppliers;
import com.supermarket.chc.supermarket.util.Page;

public class OrdersBizImpl implements OrdersBiz {
	private OrdersDao dao = new OrdersDaoImpl();

	@Override
	public List<OrdersView> list() {
		return dao.list();
	}

	@Override
	public OrdersDetail findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<OrdersView> getPageInfo(Page pages) {
		return dao.getPageInfo(pages);
	}

	@Override
	public int update(Orders order) {
		return dao.update(order);
	}

	@Override
	public int del(int id) {
		return dao.del(id);
	}

	@Override
	public int add(Orders order) {
	   return dao.add(order);
	}
	@Override
	public int findGid(String gname,int sid) {
		return dao.findGid(gname, sid);
	}

	@Override
	public List<Suppliers> findSupByGname(int gid) {
	   return dao.findSupByGname(gid);
	}

	@Override
	public List<Suppliers> findSupByGid(int gid) {
	return dao.findSupByGid(gid);
	}

	@Override
	public List<Suppliers> findSupByGname(String gname) {
	return dao.findSupByGname(gname);
	}

	@Override
	public List<OrdersView> search(String gname, String sname, String opaid) {
	return dao.search(gname, sname, opaid);
	}
	
}
