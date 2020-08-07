package com.itheima.dao;

import java.util.List;

import com.itheima.domain.ProductAccount;

public interface IProductAccountDAO {

	void add(ProductAccount pa) throws Exception;

	 List<Object[]> findByCustomer(int id) throws Exception;

}
