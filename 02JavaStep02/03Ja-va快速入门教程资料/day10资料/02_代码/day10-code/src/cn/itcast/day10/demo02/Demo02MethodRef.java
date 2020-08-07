package cn.itcast.day10.demo02;

/*
 * 方法引用的又一种格式：
 * 
 * 通过对象引用成员方法，格式：
 * 对象名::成员方法名
 */
public class Demo02MethodRef {
	
	public static void main(String[] args) {
		Cook cook = new Cook(); // 创建了一个厨师对象
		
		// 引用了cook对象当中的成员方法makeFood
		method(   cook::makeFood  );
	}
	
	public static void method(Sitter sitter) {
		sitter.work("土豆");
	}

}
