package cn.itcast.day09.demo04;

/*
 * Lambda表达式要想使用，一定要有函数式接口的推断环境。
 * 1. 要么通过方法的参数类型来确定是哪个函数式接口
 * 2. 要么通过赋值操作来确定是哪个函数式接口
 * 
 * Lambda的格式就是为了将抽象方法，翻译成为以下三点：
 * 1. 一些参数（方法参数）
 * 2. 一个箭头
 * 3. 一些代码（方法体，大括号）
 * 
 * 例如抽象方法：
 * public abstract int sum(int a, int b);
 * 
 * 翻译成为Lambda的标准格式：
 * (int a, int b) -> { return a + b; }
 */
public class Demo03Lambda {

	public static void main(String[] args) {
		// 调用方法的时候，参数类型是函数式接口，所以Lambda可以推断出来是哪个接口
		method(			(int a, int b) -> {	return a + b;}			);
		System.out.println("======================");

		// 也可以根据赋值语句左侧的类型来进行Lambda上下文推断
		Calculator param = (int a, int b) -> { return a + b; };
		method(param);

		// 错误写法！没有上下文环境，Lambda就无法推断是哪个函数式接口
		// (int a, int b) -> { return a + b; };
	}

	public static void method(Calculator calculator) {
		int result = calculator.sum(100, 200);
		System.out.println("结果是：" + result);
	}

}
