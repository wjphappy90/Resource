package cn.itcast.day05.demo04;

/*
 * 2. 对于引用数据类型（除了String）来说，形式参数的操作【会】影响实际参数。
 */
public class Demo02MethodParamRef {
	
	public static void main(String[] args) {
		int[] array = { 10, 20, 30 }; // 静态初始化一个数组
		System.out.println(array[0]); // 10
		System.out.println(array[1]); // 20
		System.out.println(array[2]); // 30
		System.out.println("=================");
		
		change(array);
		
		System.out.println("=================");
		System.out.println(array[0]); // 100
		System.out.println(array[1]); // 200
		System.out.println(array[2]); // 300
	}
	
	public static void change(int[] arr) {
		arr[0] *= 10; // 扩大十倍
		arr[1] *= 10; // 扩大十倍
		arr[2] *= 10; // 扩大十倍
		System.out.println(arr[0]); // 100
		System.out.println(arr[1]); // 200
		System.out.println(arr[2]); // 300
	}

}
