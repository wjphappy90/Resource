package com.itheima.service.impl;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.service.OrderService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.DataSourceUtils;

public class OrderServiceImpl implements OrderService {

	@Override
	/**
	 * 保存订单
	 */
	public void save(Order order) throws Exception{
		try {
			//获取dao
			OrderDao od  = (OrderDao) BeanFactory.getBean("OrderDao");
			//1.开启事务
			DataSourceUtils.startTransaction();
			
			//2.向orders表中插入一条
			od.save(order);
			
			//3.向orderitem中插入n条
			for (OrderItem oi : order.getItems()) {
				od.saveItem(oi);
			}
			
			//4.事务控制
			DataSourceUtils.commitAndClose();
		} catch (Exception e) {
			e.printStackTrace();
			DataSourceUtils.rollbackAndClose();
			throw e;
		}
	}

}
