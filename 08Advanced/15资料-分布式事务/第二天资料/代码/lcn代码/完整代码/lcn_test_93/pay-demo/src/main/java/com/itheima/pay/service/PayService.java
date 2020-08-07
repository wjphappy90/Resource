package com.itheima.pay.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;


public interface PayService {

	Integer updatePayTable( Integer id,Integer ispay);
}
