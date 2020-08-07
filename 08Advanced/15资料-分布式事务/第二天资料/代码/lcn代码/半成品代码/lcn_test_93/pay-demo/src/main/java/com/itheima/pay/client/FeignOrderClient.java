package com.itheima.pay.client;

import org.apache.ibatis.annotations.Param;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "eureka-client-order")
public interface FeignOrderClient {

	@RequestMapping(value="/demo/updateOrder")
	Integer updateOrder();
}