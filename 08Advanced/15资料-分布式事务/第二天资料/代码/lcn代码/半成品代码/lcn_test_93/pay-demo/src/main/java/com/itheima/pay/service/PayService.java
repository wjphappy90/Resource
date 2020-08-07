package com.itheima.pay.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface PayService {
	// 更新支付表中状态
	Integer updatePayTable( Integer id,Integer ispay);
}
