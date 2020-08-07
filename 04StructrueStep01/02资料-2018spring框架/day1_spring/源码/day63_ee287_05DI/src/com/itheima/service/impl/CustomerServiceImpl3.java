package com.itheima.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import com.itheima.service.ICustomerService;

/**
 * 客户的业务层实现类
 * @author zhy
 *
 */
public class CustomerServiceImpl3 implements ICustomerService {

	private String[] myStrs;
	private List<String> myList;
	private Set<String> mySet;
	private Map<String,String> myMap;
	private Properties myProps;
	

	public void setMyStrs(String[] myStrs) {
		this.myStrs = myStrs;
	}


	public void setMyList(List<String> myList) {
		this.myList = myList;
	}


	public void setMySet(Set<String> mySet) {
		this.mySet = mySet;
	}


	public void setMyMap(Map<String, String> myMap) {
		this.myMap = myMap;
	}


	public void setMyProps(Properties myProps) {
		this.myProps = myProps;
	}


	@Override
	public void saveCustomer() {
		System.out.println(Arrays.toString(myStrs));
		System.out.println(myList);
		System.out.println(mySet);
		System.out.println(myMap);
		System.out.println(myProps);
	}







}
