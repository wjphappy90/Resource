package cn.itcast.day10.demo02;

/*
 * JDK当中已经给我们提供好了一个java.lang.Math类，其中有一个静态方法abs就可以实现求绝对值的功能。
 * 既然Math.abs方法已经存在了现成的做法，那么我就没有必要再用Lambda自己写一遍了。
 * 就可以通过方法引用，直接拿过来用。
 * 
 * 格式：
 * 类名称::静态方法名
 */
public class Demo01Abs {
	
	public static void main(String[] args) {
		method(num -> {
			int result;
			if (num >= 0) { // 如果是正数或者是0，那么原封不动
				result = num;
			} else { // 否则就是负数，应该负负为正
				result = -num;
			}
			return result;
		});
		System.out.println("==================");
		
		// 方法引用的意义：Math类当中有一个abs静态方法，已经有了现成的功能，直接拿过来用。
		method(Math::abs);
	}
	
	public static void method(Calculator calculator) {
		int result = calculator.getAbs(-25);
		System.out.println("结果是：" + result);
	}

}
