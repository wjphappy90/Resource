package com.itheima.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.itheima.mapper.ProductMapper;
import com.itheima.pojo.Product;
import com.itheima.service.ProductService;

/**
 * 
 * 描述:商品服务实现类
 * @author zhuan
 * @version 2018年2月28日 下午8:21:43
 */
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductMapper productMapper;
	/**
	 * 查询所有商品
	 */
	@Override
	public List<Product> findAll() {
		return productMapper.findProductList();
	}
	

	
	
}
