package cn.itcast.day10.demo01;

public class Demo02StaticInvoke {
	
	public static void main(String[] args) {
		// 希望调用Cook这个类当中的静态方法makeFood
		// 类名称.静态方法名(参数值)
		Cook.makeFood("白菜");
	}

}
