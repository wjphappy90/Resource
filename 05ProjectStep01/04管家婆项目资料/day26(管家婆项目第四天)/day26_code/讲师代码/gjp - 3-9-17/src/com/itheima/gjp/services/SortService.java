package com.itheima.gjp.services;

import java.util.List;

import com.itheima.gjp.dao.SortDao;
import com.itheima.gjp.domain.Sort;

/**
 * 
 * @author apple
 * 分类功能的业务层
 * 
 * 分类的控制层controller调用services功能
 * services调用dao层功能
 */
public class SortService {
    //创建dao层,SortDao类的对象
	private SortDao sortDao = new SortDao();
	
	/*
	 * 定义方法,调用dao成SortDao#querySortNameByParent(String parent)
	 * 查询所有的分类名称,传递String参数,父分类
	 */
	public List<Object> querySortNameByParent(String parent){
		return sortDao.querySortNameByParent(parent);
	}
	
	/*
	 * 定义方法,调用dao层SortDao#querySortNameAll()查询所有分类名称
	 * 返回List集合
	 */
	public  List<Object> querySortNameAll(){
		return sortDao.querySortNameAll();
	}
	
	
	/*
	 * 定义方法，调用dao层SortDao#deleteSort()实现编辑分类
	 * 传递Sort对象
	 * 是contorller调用services层传递Sort
	 */
	public void deleteSort(Sort sort){
		sortDao.deleteSort(sort);
	}
	
	/*
	 * 定义方法，调用dao层SortDao#editSort()实现编辑分类
	 * 传递Sort对象
	 * 是contorller调用services层传递Sort
	 */
	public void editSort(Sort sort){
		sortDao.editSort(sort);
	}
	
	/*
	 * 定义方法，调用dao层SortDao#addSort()添加分类
	 * 传递Sort对象
	 * services层方法中的Sort对象，是contorller传递的
	 */
	public void addSort(Sort sort){
		sortDao.addSort(sort);
	}
	
	/*
	 * 定义方法，调用dao层 SortDao#querySortAll获取所有的分类的数据
	 * 返回的是List集合，存储Sort对象
	 */
	public List<Sort> querySortAll(){
		return sortDao.querySortAll();
	}
}
