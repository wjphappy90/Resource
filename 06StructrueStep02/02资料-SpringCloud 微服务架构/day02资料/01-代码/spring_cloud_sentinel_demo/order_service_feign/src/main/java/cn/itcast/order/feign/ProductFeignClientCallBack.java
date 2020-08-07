package cn.itcast.order.feign;

import cn.itcast.order.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductFeignClientCallBack implements ProductFeignClient {

	/**
	 * 熔断降级的方法
	 */
	public Product findById(Long id) {
		Product product = new Product();
		product.setProductName("feign调用触发熔断降级方法");
		return product;
	}
}
