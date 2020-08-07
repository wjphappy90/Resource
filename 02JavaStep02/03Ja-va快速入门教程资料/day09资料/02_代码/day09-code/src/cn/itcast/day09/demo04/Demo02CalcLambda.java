package cn.itcast.day09.demo04;

public class Demo02CalcLambda {

	public static void main(String[] args) {
		method((x, y) -> x + y);
		// Lambda表达式：(x, y) -> x + y
		// method方法需要一个Calculator接口类型的参数
		// Lambda表达式就是充当了Calculator接口类型的参数
		// 初步理解：
		// 1. Lambda表达式前面的小括号，其实就是接口抽象方法的小括号。
		// 2. 箭头代表拿着小括号的数据做什么事情，是一个指向的动作。
		// 3. 箭头后面就代表拿到了参数之后做什么事情。
		// Lambda表达式的语义本身就代表了怎么做这件事情，没有对象的概念在里面。（更加简单直观。）
	}

	public static void method(Calculator calculator) {
		int result = calculator.sum(100, 200);
		System.out.println("结果是：" + result);
	}

}
