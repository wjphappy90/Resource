package cn.itcast.order.controller;

import cn.itcast.order.command.OrderCommand;
import cn.itcast.order.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;


	/**
	 * 使用OrderCommand调用远程服务
	 */
	@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		return new OrderCommand(restTemplate,id).execute();
	}


	@RequestMapping(value = "/{id}",method = RequestMethod.GET)
	public String findOrder(@PathVariable Long id) {
		System.out.println(Thread.currentThread().getName());
		return "根据id查询订单";
	}
}
