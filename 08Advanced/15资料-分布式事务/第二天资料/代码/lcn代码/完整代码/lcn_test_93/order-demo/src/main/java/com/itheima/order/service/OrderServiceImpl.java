package com.itheima.order.service;

import com.codingapi.tx.annotation.ITxTransaction;
import com.codingapi.tx.annotation.TxTransaction;
import com.itheima.order.mapper.OrderMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/demo")
public class OrderServiceImpl implements OrderService{
	/**
	 *1.注入订单表的mapper
	 *2.更新订单表
	*3.开启本地事务
	 * 发布对外接口(原本应该写controller层,这里为了简化,直接加上controller注解)
	*4.整合lcn框架,实现分布式事务
	 * 加入tc模块:
	 * 加入lcn的jar包
	*4.1 与tm通信,需要通讯模块
	 * 4.2接管数据源
	 * 4.3添加lcn注解,开启分布式事务
	 */


	@Resource
	private OrderMapper orderMapper;

	@RequestMapping("/updateOrder")
	@TxTransaction
	@Transactional
	@Override
	public int updateOrder() {
		return orderMapper.update(1111,1);
	}
}
