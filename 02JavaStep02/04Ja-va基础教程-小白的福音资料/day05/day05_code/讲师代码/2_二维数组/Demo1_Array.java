/*
* A:二维数组概述
* B:二维数组格式1
	* int[][] arr = new int[3][2]; 
* C:二维数组格式1的解释
* D:注意事项
	* a:以下格式也可以表示二维数组
		* 1:数据类型 数组名[][] = new 数据类型[m][n];
		* 2:数据类型[] 数组名[] = new 数据类型[m][n];
	* B:注意下面定义的区别
	* 
			int x;
			int y;
			int x,y;
			
			int[] x;
			int[] y[];
			
			int[] x,y[];	x是一维数组,y是二维数组
* E:案例演示
	* 定义二维数组，输出二维数组名称，一维数组名称，一个元素
*/
class Demo1_Array {
	public static void main(String[] args) {
		int[][] arr = new int[3][2];
		/*
		这是一个二维数组
		这个二维数组中有3个一维数组
		每个一维数组中有2个元素

		[[I@19bb25a									//二维数组的地址值
		[I@da6bf4									//一维数组的地址值
		0											//元素值
		*/
		System.out.println(arr);					//二维数组
		System.out.println(arr[0]);					//二维数组中的第一个一维数组
		System.out.println(arr[0][0]);				//二维数组中的第一个一维数组的第一个元素
	}
}
