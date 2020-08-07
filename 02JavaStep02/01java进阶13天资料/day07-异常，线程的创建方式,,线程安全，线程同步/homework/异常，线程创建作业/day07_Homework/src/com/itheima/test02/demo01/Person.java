package com.itheima.test02.demo01;
/*
定义Person类
a)  属性：名称(name)和生命值(lifeValue)
b)  提供空参构造
c)  提供有参构造
	i.  使用setXxx方法给name和lifeValue赋值
d)  提供setter和getter方法
	i.  在setLifeValue(intlifeValue)方法中
		1. 如果 lifeValue为负数,就抛出NoLifeValueException,异常信息为：生命值不能为负数:xxx.
		2. 然后在给成员lifeValue赋值.
 */
public class Person {
	// 名称(name)
	private String name;
	// 生命值(lifeValue)
	private int lifeValue;

	// 空参构造
	public Person() {
		super();
	}

	// c)提供有参构造;
	public Person(String name, int lifeValue) {
		super();
		// i.使用setXxx方法给name和lifeValue赋值
		setName(name);
		setLifeValue(lifeValue);
	}

	// d)提供setter和getter方法
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLifeValue() {
		return lifeValue;
	}

	// i.在setLifeValue(int lifeValue)方法中
	public void setLifeValue(int lifeValue) {
		// 1.首先判断,如果 lifeValue为负数,就抛出NoLifeValueException,异常信息为:生命值不能为负数:xxx.
		if (lifeValue < 0) {
			throw new NoLifeValueExption("生命值不能为负数:" + lifeValue);
		}
		// 2.然后在给成员lifeValue赋值.
		this.lifeValue = lifeValue;
	}
}
