package com.itheima.sh.service;

import com.itheima.sh.dao.ProductDao;
import com.itheima.sh.domain.Product;
import com.mongodb.DBCursor;

public class ProductService {
	// 创建dao层的对象
	ProductDao dao = new ProductDao();

	// 查询所有商品信息
	public DBCursor findAllProducts() throws Exception {
		return dao.findAllProducts();
	}

	// 根据商品编号查询商品信息
	public DBCursor findProductsByPid(int pid) throws Exception {
		// TODO Auto-generated method stub
		return dao.findProductsByPid(pid);
	}

	// 添加商品
	public void addProduct(Product p) throws Exception {
		dao.addProduct(p);
	}
	//根据编号删除商品
	public void deleteProductByPid(int pid) throws Exception {
		dao.deleteProductByPid(pid);
		
	}

}
