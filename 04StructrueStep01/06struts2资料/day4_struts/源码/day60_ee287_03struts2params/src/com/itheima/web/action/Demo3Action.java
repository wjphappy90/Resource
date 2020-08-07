package com.itheima.web.action;

import com.itheima.domain.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 请求参数封装
 * 第三种情况：		我们在后面用的最多的方式
 * 	  模型驱动
 * 要想封装成功，需要按照要求书写：
 * 	1、动作类必须实现ModelDriven接口
 * 	2、动作类中需要定义模型，并且必须实例化出来
 * 	3、提供接口抽象方法的实现，返回值必须是模型对象
 * 	
 * 执行参数封装，是一个名称为params的拦截器实现的。
 * 模型驱动的实现，出来params拦截器之外，还需要一个叫modelDriven的拦截器配合
 * 封装的规则只有一个，它要去指定位置找属性，找到之后调用set方法赋值。			
 * 
 * @author zhy
 *
 */
public class Demo3Action extends ActionSupport implements ModelDriven<User>{

	private User user = new User();
	
	@Override
	public User getModel() {
		return user;
	}
	/**
	 * 动作方法
	 * @return
	 */
	public String demo3(){
		System.out.println(user);
		return SUCCESS;
	}


	
}
