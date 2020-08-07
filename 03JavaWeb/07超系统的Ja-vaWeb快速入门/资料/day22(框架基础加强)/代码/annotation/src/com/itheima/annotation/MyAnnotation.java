package com.itheima.annotation;

public @interface MyAnnotation {

	public String[] show(); // 在注解中，我们管它叫做注解属性

	boolean[] a(); // 基本类型

	MyEnum[] me(); // 枚举类型

	MyAnnotation2[] ma2(); // 注解类型

	Class[] clazz(); //Class类型

}
