package com.itheima.service;

import com.itheima.domain.Order;
import com.itheima.domain.PageBean;

public interface OrderService {

	void save(Order order)throws Exception;

	PageBean<Order> findMyOrdersByPage(int pageNumber, int pageSize, String uid)throws Exception;

	Order getById(String oid)throws Exception;

	void update(Order order)throws Exception;

}
