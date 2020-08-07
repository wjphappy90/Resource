package cn.itcast.order.controller;

import cn.itcast.order.entity.Product;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
/**
 * @DefaultProperties : 指定此接口中公共的熔断设置
 *      如果过在@DefaultProperties指定了公共的降级方法
 *      在@HystrixCommand不需要单独指定了
 */
//@DefaultProperties(defaultFallback = "defaultFallBack")
public class OrderController {

	@Autowired
	private RestTemplate restTemplate;


	/**
	 * 使用注解配置熔断保护
	 *     fallbackmethod : 配置熔断之后的降级方法
	 */
	@HystrixCommand(fallbackMethod = "orderFallBack")
	@RequestMapping(value = "/buy/{id}",method = RequestMethod.GET)
	public Product findById(@PathVariable Long id) {
		if(id != 1) {
			throw  new  RuntimeException("服务器异常");
		}
		return restTemplate.getForObject("http://service-product/product/1",Product.class);
	}


	/**
	 * 指定统一的降级方法
	 *  * 参数 : 没有参数
	 */
	public Product defaultFallBack() {
		Product product = new Product();
		product.setProductName("触发统一的降级方法");
		return product;
	}

	/**
	 * 降级方法
	 *  和需要收到保护的方法的返回值一致
	 *  方法参数一致
	 */
	public Product orderFallBack(Long id) {
		Product product = new Product();
		product.setProductName("触发降级方法");
		return product;
	}

}
