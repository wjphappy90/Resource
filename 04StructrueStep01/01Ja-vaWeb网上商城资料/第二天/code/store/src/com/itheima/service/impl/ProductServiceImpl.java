package com.itheima.service.impl;

import java.util.List;

import com.itheima.dao.ProductDao;
import com.itheima.dao.impl.ProductDaoImpl;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;

public class ProductServiceImpl implements ProductService {

	@Override
	/**
	 * 查询热门商品
	 */
	public List<Product> findHot() throws Exception {
		ProductDao pd= new ProductDaoImpl();
		return pd.findHot();
	}

	@Override
	/**
	 * 查询最新商品
	 */
	public List<Product> findNew() throws Exception {
		ProductDao pd= new ProductDaoImpl();
		return pd.findNew();
	}

	@Override
	/**
	 * 单个商品详情
	 */
	public Product getById(String pid) throws Exception {
		ProductDao pd=new ProductDaoImpl();
		
		return pd.getById(pid);
	}

	@Override
	/**
	 * 分页展示分类商品
	 */
	public PageBean<Product> findByPage(int pageNumber, int pageSize, String cid) throws Exception {
		ProductDao pDao= new ProductDaoImpl();
		//1.创建pagebean
		PageBean<Product> pb = new PageBean<>(pageNumber, pageSize);
		
		//2.设置当前页数据
		List<Product> data = pDao.findByPage(pb,cid);
		pb.setData(data);
		
		//3.设置总记录数
		int totalRecord = pDao.getTotalRecord(cid);
		pb.setTotalRecord(totalRecord);
		
		return pb;
	}

}
