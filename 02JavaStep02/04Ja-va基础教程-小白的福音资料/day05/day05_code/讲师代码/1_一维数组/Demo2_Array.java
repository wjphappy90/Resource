/*
* A:什么是数组的初始化
	* 就是为数组开辟连续的内存空间，并为每个数组元素赋予值 
* B:如何对数组进行初始化
	* a:动态初始化 只指定长度，由系统给出初始化值
		* int[] arr = new int[5]; 	
	* b:静态初始化 给出初始化值，由系统决定长度	
* C:动态初始化的格式：
	* 数据类型[] 数组名 = new 数据类型[数组长度];
* D:案例演示
	* 输出数组名称和数组元素

	整数类型:byte,short,int,long默认初始化值都是0
	浮点类型:float,double默认初始化值都是0.0
	布尔类型:boolean默认初始化值false
	字符类型:char默认初始化值'\u0000'
	char在内存中占的两个字节,是16个二进制位
	\u0000,每一个0其实代表的是16进制的0,那么四个0就是代表16个二进制位

	[I@19bb25a

	[代表是数组,几个就代表几维
	I代表是int类型
	@是固定的
	19bb25a代表的是数组的地址值
*/
class Demo2_Array {
	public static void main(String[] args) {
		//数据类型[] 数组名 = new 数据类型[数组长度];
		int[] arr = new int[5];				//动态初始化,在内存中开辟连续的5块空间

		System.out.println(arr[0]);			//系统给出默认初始化值,整数类型的都是0
											
		arr[0] = 10;

		System.out.println(arr[0]);	

		System.out.println(arr);			//[I@19bb25a
	}
}
