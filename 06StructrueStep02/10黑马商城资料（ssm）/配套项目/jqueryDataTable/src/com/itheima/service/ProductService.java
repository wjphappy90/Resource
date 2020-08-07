package com.itheima.service;
import java.util.List;

import com.itheima.pojo.Product;
/**
 * 
 * 描述:商品-服务层接口
 * @author zhuan
 * @version 2018年2月7日 下午7:17:12
 */
public interface ProductService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<Product> findAll();
	
}
