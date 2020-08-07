package com.itheima.service.impl;

import java.util.List;

import com.itheima.constant.Constant;
import com.itheima.dao.CategoryDao;
import com.itheima.dao.impl.CategoryDaoImpl;
import com.itheima.domain.Category;
import com.itheima.service.CategoryService;
import com.itheima.utils.JedisUtils;
import com.itheima.utils.JsonUtil;

import redis.clients.jedis.Jedis;

public class CategoryServiceImpl implements CategoryService {

	@Override
	/**
	 * 查询所有分类
	 */
	public String findAll() throws Exception {
		//1.调用dao 查询所有分类
		CategoryDao cd = new CategoryDaoImpl();
		List<Category> list = cd.findAll();
		
		//2.将list转换成json字符串
		if(list!=null && list.size()>0){
			return JsonUtil.list2json(list);
		}
		return null;
	}

	@Override
	/**
	 * 从redis中获取所有的分类
	 */
	public String findAllFromRedis() throws Exception {
		//1.获取jedis
		Jedis jedis = JedisUtils.getJedis();
		
		//2.从redis中获取数据
		String value = jedis.get(Constant.STORE_CATEGORY_LIST);
		
		//3.判断数据是否为空
		if(value == null){
			//3.1若为空 ,调用findAll() 将查询的结果放入redis return
			value = findAll();
			
			jedis.set(Constant.STORE_CATEGORY_LIST, value);
			System.out.println("从mysql中获取");
			return value;
		}
		//3.2若不为空,return
		System.out.println("从redis中获取");
		
		return value;
	}

}
