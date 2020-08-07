package com.itheima.dao;

import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;

public interface OrderDao {

	void save(Order order) throws Exception;

	void saveItem(OrderItem oi) throws Exception;

}
