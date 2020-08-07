package cn.itcast.day09.demo05;

/*
 * 在Lambda表达式当中，凡是可以推导的，都是可以省略的。
 * 
 * 1. Lambda表达式当中的参数类型可以省略不写。
 * 2. 如果参数有且只有一个，那么小括号可以省略。
 * 3. 如果语句只有一个，那么大括号和return也可以省略。
 */
public class DemoLambdaSimple {
	
	public static void main(String[] args) {
		// 标准格式：
		method(            (int x) -> { return ++x; }              );
		
		// 省略参数类型：
		method(            (x) -> { return ++x; }              );
		
		// 省略参数小括号：
		method(            x -> { return ++x; }              );
		
		// 省略大括号和return关键字：
		method(            x -> ++x              );
		
	}
	
	public static void method(MyInter inter) {
		int result = inter.singlePlus(10);
		System.out.println("结果：" + result);
	}

}
