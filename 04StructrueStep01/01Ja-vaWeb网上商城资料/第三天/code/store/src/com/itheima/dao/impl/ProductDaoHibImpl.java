package com.itheima.dao.impl;

import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

public class ProductDaoHibImpl implements ProductDao {

	@Override
	public List<Product> findHot() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findNew() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product getById(String pid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findByPage(PageBean<Product> pb, String cid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalRecord(String cid) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
