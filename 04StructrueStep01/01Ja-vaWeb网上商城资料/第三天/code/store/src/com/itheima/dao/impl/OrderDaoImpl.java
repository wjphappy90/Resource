package com.itheima.dao.impl;

import org.apache.commons.dbutils.QueryRunner;

import com.itheima.dao.OrderDao;
import com.itheima.domain.Order;
import com.itheima.domain.OrderItem;
import com.itheima.utils.DataSourceUtils;

public class OrderDaoImpl implements OrderDao {

	@Override
	/**
	 * 保存订单
	 */
	public void save(Order o) throws Exception {
		QueryRunner qr = new QueryRunner();
		/**
		 * `oid` varchar(32) NOT NULL,
			  `ordertime` datetime DEFAULT NULL,
			  `total` double DEFAULT NULL,
			  
			  `state` int(11) DEFAULT NULL,
			  `address` varchar(30) DEFAULT NULL,
			  `name` varchar(20) DEFAULT NULL,
			  
			  `telephone` varchar(20) DEFAULT NULL,
			  `uid` varchar(32) DEFAULT NULL,
		 */
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		qr.update(DataSourceUtils.getConnection(), sql, o.getOid(),o.getOrdertime(),o.getTotal(),
				o.getState(),o.getAddress(),o.getName(),
				o.getTelephone(),o.getUser().getUid());
	}

	@Override
	/**
	 * 保存订单项
	 */
	public void saveItem(OrderItem oi) throws Exception {
		QueryRunner qr = new QueryRunner();
		/*
		 * `itemid` varchar(32) NOT NULL,
				  `count` int(11) DEFAULT NULL,
				  `subtotal` double DEFAULT NULL,
				  
				  `pid` varchar(32) DEFAULT NULL,
				  `oid` varchar(32) DEFAULT NULL,
		 */
		String sql = "insert into orderitem values(?,?,?,?,?)";
		qr.update(DataSourceUtils.getConnection(), sql, oi.getItemid(),oi.getCount(),oi.getSubtotal(),
				oi.getProduct().getPid(),oi.getOrder().getOid());
	}

}
