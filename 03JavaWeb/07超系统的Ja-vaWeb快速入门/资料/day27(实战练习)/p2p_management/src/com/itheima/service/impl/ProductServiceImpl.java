package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.IProductDAO;
import com.itheima.dao.impl.ProductDAOImpl;
import com.itheima.domain.PageBean;
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

	@Override
	public PageBean<Product> findByPage(int pageNum, int pageSize) throws Exception {
		PageBean<Product> pb = new PageBean<Product>();
		IProductDAO productDao = new ProductDAOImpl();
		// 1.总条数
		int totalCount = productDao.findAllCount();
		// 2.总页数
		int totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);
		// 3.当前页数据
		List<Product> ps = productDao.findByPage(pageNum, pageSize);

		// 4.封装数据到pageBean
		pb.setContent(ps);
		pb.setPageNum(pageNum);
		pb.setPageSize(pageSize);
		pb.setTotalCount(totalCount);
		pb.setTotalPage(totalPage);
		return pb;
	}

}
