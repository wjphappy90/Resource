package cn.itcast.day05.demo01;

/*
 * 定义一个方法，实现两个int数字相加得到和值的功能。
 * 
 * 注意事项：
 * 1. 多个方法之间定义的前后顺序无所谓。
 * 2. 不能在一个方法的内部嵌套定义另一个方法。
 * 3. 方法定义了之后，不会执行；如果要想执行，一定要调用。
 */
public class Demo02MethodDefine {
	
	/*
	 * 定义方法的三要素
	 * 返回值类型：两个int数据相加，结果肯定还是int
	 * 方法名称：sum
	 * 参数列表：两个int类型
	 */
	public static int sum(int a, int b) {
		System.out.println("方法sum执行啦！");
		int result = a + b;
		return result;
	}
	
	public static void main(String[] args) {
		
	}

}
