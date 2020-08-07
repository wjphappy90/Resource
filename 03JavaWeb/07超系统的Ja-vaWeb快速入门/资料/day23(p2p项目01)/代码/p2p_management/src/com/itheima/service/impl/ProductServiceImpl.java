package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.IProductDAO;
import com.itheima.dao.impl.ProductDAOImpl;
import com.itheima.domain.Product;
import com.itheima.service.IProductService;

public class ProductServiceImpl implements IProductService {
	// 查询所有
	@Override
	public List<Product> findAll() {
		IProductDAO productDao = new ProductDAOImpl();
		try {
			return productDao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 添加
	@Override
	public void add(Product p) {
		IProductDAO productDao = new ProductDAOImpl();
		productDao.add(p);
	}

	// 根据id查询
	@Override
	public Product findById(int id) {
		IProductDAO productDao = new ProductDAOImpl();
		try {
			return productDao.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 根据id修改产品
	@Override
	public void update(Product p) {
		IProductDAO productDao = new ProductDAOImpl();
		try {
			productDao.update(p);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
