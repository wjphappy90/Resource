package com.itheima.web.action;

import java.util.ArrayList;
import java.util.List;

import com.itheima.domain.Student;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * ValueStack的数据存取
 * @author zhy
 *
 */
public class Demo2Action extends ActionSupport {
	
	private String name = "泰斯特";

	public String getName() {
		return name;
	}

	/**
	 * 获取ValueStack，并且压栈操作
	 * @return
	 */
	public String demo2(){
		//1.获取ActionContext
		ActionContext context = ActionContext.getContext();//从当前线程上获取
		//2.获取ValueStack对象
		ValueStack vs = context.getValueStack();
		//3.压栈操作
		Student s = new Student("张三",18,"male");
		
//		List<Student> list = new ArrayList<Student>();
//		list.add(s);
		vs.push(s);
		return SUCCESS;
	}
}
