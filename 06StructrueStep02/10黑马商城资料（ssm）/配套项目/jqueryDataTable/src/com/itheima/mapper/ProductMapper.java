package com.itheima.mapper;

import java.util.List;

import com.itheima.pojo.Product;
/**
 * 
 * 描述:商品mapper代理
 * @author zhuan
 * @version 2018年2月28日 下午8:37:51
 */
public interface ProductMapper {
    /**
     * 
     * 描述:
     * @return
     */
	public List<Product> findProductList();
}