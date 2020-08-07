package cn.itcast.day09.demo03;

public class Demo01Calc {
	
	public static void main(String[] args) {
		// 首先使用接口的格式来创建了一个计算器对象
		Calculator calculator = new CalculatorImpl();
		
		// 将计算器对象交给method方法去使用
		method(calculator);
	}
	
	// 参数是接口类型：计算器接口
	public static void method(Calculator calculator) {
		int result = calculator.sum(10, 20);
		System.out.println("结果是：" + result);
	}

}
