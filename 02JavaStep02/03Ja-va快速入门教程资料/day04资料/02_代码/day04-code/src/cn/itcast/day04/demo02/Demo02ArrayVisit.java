package cn.itcast.day04.demo02;

/*
 * 如何访问数组当中的元素？
 * 
 * 如果直接打印数组的名称，那么到底的是16进制的地址值（的哈希值）。
 * 
 * 二进制：01
 * 10进制：0123456789			18
 * 16进制：0123456789abcdef		0x12
 * 
 * 如何访问数组当中的一个具体元素呢？格式：
 * 数组名称[索引]
 * 索引：也就是数组当中多个元素的编号，【从0开始】，一直到“长度-1”为止。
 * 
 * 动态初始化的时候，数组当中的元素都会被赋予一个默认值。规则：
 * 如果是整数，默认就是0；如果是浮点数，默认就是0.0；如果是字符，默认就是'\u0000'（Unicode写法）；
 * 如果是布尔值，默认就是false；如果是字符串或其他引用类型，那么默认null（闹，空常量）。
 */
public class Demo02ArrayVisit {
	
	public static void main(String[] args) {
		int[] arrayA = new int[3];
		
		System.out.println(arrayA); // 数组名称，[I@6d1e7682
		System.out.println(arrayA[0]); // 第0号元素，0
		System.out.println(arrayA[1]); // 第1号元素，0
		System.out.println(arrayA[2]); // 第2号元素，0
		
		System.out.println("===================");
		
		double[] arrayB = new double[3];
		System.out.println(arrayB); // 数组名称，打印得到地址值，[D@424c0bc4
		System.out.println(arrayB[0]); // 0.0
		System.out.println(arrayB[1]); // 0.0
		System.out.println(arrayB[2]); // 0.0
		
		System.out.println("===================");
		
		// 改变数组当中的具体元素
		arrayB[1] = 3.14;
		System.out.println(arrayB[0]); // 0.0
		System.out.println(arrayB[1]); // 3.14
		System.out.println(arrayB[2]); // 0.0
		
		// 将一个具体的数组元素的数据，赋值给一个变量
		double num = arrayB[1];
		System.out.println("num变量的内容是：" + num);
	}

}
