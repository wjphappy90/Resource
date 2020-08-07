package cn.itcast.day10.demo01;

/*
 * 定义方法的时候，有static和没有static有什么区别？
 * 
 * 有static的方法：叫做静态方法。
 * 没有static的方法：叫做成员方法（实例方法）。
 * 
 * 定义静态方法的格式：
 * public static 返回值类型 方法名称(参数类型 参数名称) {
 * 		// 方法体
 * }
 * 
 * 定义成员方法的格式：
 * public 返回值类型 方法名称(参数类型 参数名称) {
 * 		// 方法体
 * }
 * 
 * 调用静态方法的格式：
 * 		方法名(参数值);					// 直接调用本类当中的静态方法
 * 		类名称.方法名(参数值);			// 调用另外一个类当中的静态方法
 * 调用成员方法的格式：
 * 		类名称 对象名 = new 类名称(); 	// 首先创建对象
 * 		对象名.成员方法名(参数值);		// 通过对象名调用成员方法
 * 
 * 1. 如果不创建对象，那么通过类名称只能调用静态方法。
 * 2. 如果创建了对象，那么通过对象名可以调用成员方法。
 * 3. 通过对象名也可以调用静态方法，然而不推荐这么做。
 */
public class Demo01StaticVsInstance {
	
	public static void main(String[] args) {
		method1(); // 调用本类当中的静态方法
		
		// 注意，本类当中的静态方法，也可以通过类名称进行调用。
		Demo01StaticVsInstance.method1(); // 调用本类当中的静态方法
		
		MyClass.method2(); // 调用另外一个类当中的静态方法
		
		// 需要调用成员方法，就必须借助对象
		MyClass obj = new MyClass(); // 一定要首先创建一个对象
		obj.method3(); // 然后才能通过对象去调用成员方法
		
		obj.method2(); // 这种写法也可以，但是不推荐！
	}
	
	public static void method1() {
		System.out.println("静态方法1执行！");
	}

}
