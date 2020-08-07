package com.itheima.service;

import java.sql.SQLException;
import java.util.List;

import com.itheima.dao.ProductDAO;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

public class ProductService {

	// public List<Product> findAll(int pageNo,int pageSize) throws SQLException
	// {
	// ProductDAO dao=new ProductDAO();
	// return dao.findAll(pageNo,pageSize);
	// }

	// 使用PageBean来处理分页数据
	public PageBean findAll(int pageNo, int pageSize) throws SQLException {
		ProductDAO dao = new ProductDAO();
		List<Product> ps = dao.findAll(pageNo, pageSize); // 查询的分页的产品信息

		PageBean<Product> pb = new PageBean<Product>();
		// 将分页数据封装到PageBean中
		pb.setPageNo(pageNo);
		pb.setContent(ps);
		pb.setPageSize(pageSize);
		// 总条数 select count(*) from product表查询?总页数可以根据总条数据查询
		int totalCount = dao.findAllCount();
		int totalPage = (int) Math.ceil(totalCount * 1.0 / pageSize);
		pb.setTotalPage(totalPage);
		pb.setTotalCount(totalCount);

		return pb;
	}
}
