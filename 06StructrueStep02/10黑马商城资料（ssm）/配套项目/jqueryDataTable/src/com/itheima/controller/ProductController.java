package com.itheima.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itheima.pojo.DataTableResult;
import com.itheima.pojo.Product;
import com.itheima.service.ProductService;

/**
 * 
 * 描述:商品管理 -controller
 * @author zhuan
 * @version 2018年2月7日 下午7:43:15
 */
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	/**
	 * 
	 * 描述:
	 * @return DataTableResult 
	 */
	@RequestMapping("/findProductList.do")
	public DataTableResult findAllSku(){
		DataTableResult dataTableResult = new DataTableResult();
		List<Product> list = productService.findAll();
		dataTableResult.setData(list);
		System.out.println("findProductList被调用...");
		return dataTableResult;
	}
}
