package com.supermarket.chc.supermarket.biz.impl;

import java.util.List;

import com.supermarket.chc.supermarket.biz.SuppliersBiz;
import com.supermarket.chc.supermarket.dao.SuppliersDao;
import com.supermarket.chc.supermarket.dao.impl.SuppliersDaoImpl;
import com.supermarket.chc.supermarket.entity.Suppliers;
import com.supermarket.chc.supermarket.util.Page;

public class SuppliersBizImpl implements SuppliersBiz {
   SuppliersDao dao=new SuppliersDaoImpl();
	@Override
	public List<Suppliers> list() {
	return dao.list();
	}

	@Override
	public Suppliers findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Suppliers> getPageInfo(Page pages) {
		return dao.getPageInfo(pages);
	}

	@Override
	public int update(Suppliers suppliers) {
	return dao.update(suppliers);
	}

	@Override
	public int del(int id) {
	  return dao.del(id);
	}

	@Override
	public int add(Suppliers suppliers) {
		return dao.add(suppliers);
	}

	@Override
	public Suppliers findByIdForUpdate(int id) {
	return dao.findByIdForUpdate(id);
	}

	@Override
	public List<Suppliers> findByName(String name) {
	return dao.findByName(name);
	}

}
