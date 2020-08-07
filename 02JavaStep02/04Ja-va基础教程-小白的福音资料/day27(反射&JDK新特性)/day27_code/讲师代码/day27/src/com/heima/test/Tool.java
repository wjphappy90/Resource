package com.heima.test;

import java.lang.reflect.Field;

public class Tool {
	//此方法可将obj对象中名为propertyName的属性的值设置为value。
	public void setProperty(Object obj, String propertyName, Object value) throws Exception {
		Class clazz = obj.getClass();					//获取字节码对象
		Field f = clazz.getDeclaredField(propertyName);	//暴力反射获取字段
		f.setAccessible(true);							//去除权限
		f.set(obj, value);
	}
}
