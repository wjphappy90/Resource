package cn.itcast.day08.demo05;

/*
 * 方法的返回值可以是什么类型？
 * 
 * 1. 基本类型
 * 2. 数组
 * 3. 字符串
 * 4. 自定义的类
 * 
 * 所有数据类型都可以作为方法的返回值类型。
 */
public class Demo02MethodReturn {
	
	public static void main(String[] args) {
		int result1 = method1();
		System.out.println(result1); // 100
		System.out.println("==================");
		
		int[] result2 = method2();
		System.out.println(result2[0]); // 10
		System.out.println(result2[1]); // 20
		System.out.println("==================");
		
		String result3 = method3();
		System.out.println(result3.replace("o", "*")); // H*w d* y*u d*?
		System.out.println("==================");
		
		Student result4 = method4();
		// 姓名：赵丽颖，年龄：20
		System.out.println("姓名：" + result4.getName() + "，年龄：" + result4.getAge());
	}
	
	// 使用基本类型作为方法的返回值，可以
	public static int method1() {
		int num = 100;
		return num;
	}
	
	// 使用数组类型作为方法的返回值，也可以
	public static int[] method2() {
		int[] array = { 10, 20 };
		return array;
	}
	
	// 使用字符串作为方法的返回值，还可以
	public static String method3() {
		String str = "How do you do?";
		return str;
	}
	
	// 使用自定义的类作为方法的返回值，仍然可以
	public static Student method4() {
		Student stu = new Student("赵丽颖", 20);
		return stu;
	}

}
