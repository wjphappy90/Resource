package com.itheima.service;

import java.util.List;

import com.itheima.domain.Product;

public interface IProductService {

	List<Product> findAll();

	void add(Product p);

	Product findById(int id);

	void update(Product p);

}
