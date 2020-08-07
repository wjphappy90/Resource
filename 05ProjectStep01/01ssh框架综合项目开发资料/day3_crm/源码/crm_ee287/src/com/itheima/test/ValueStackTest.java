package com.itheima.test;

import java.util.ArrayList;
import java.util.List;

import com.itheima.domain.Customer;

public class ValueStackTest {

	public static void main(String[] args) {
		Customer c = new Customer();
		List<Customer> list = new ArrayList<Customer>();
		list.add(c);//压栈
		System.out.println(list);//压完栈就输出，集合中的对象是空的
		//调用动作方法
		findCustomer(c);
		
		System.out.println("走完动作方法之后，再来看看值栈中的对象："+list);
	}

	public static void findCustomer(Customer c){
		c.setCustName("设置客户名称");
	}
}
