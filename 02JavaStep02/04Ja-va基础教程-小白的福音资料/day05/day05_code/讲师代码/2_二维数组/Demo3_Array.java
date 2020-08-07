/*
* A:二维数组格式2
	* int[][] arr = new int[3][]; 
* B:二维数组格式2的解释
* C:案例演示
	* 讲解格式，输出数据，并画内存图
*/
class Demo3_Array {
	public static void main(String[] args) {
		int[][] arr = new int[3][];				//这是一个二维数组,这个二维数组中有三个一维数组,三个一维数组都没有被赋值
		
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		arr[0] = new int[3];					//第一个一维数组中可以存储三个int值
		arr[1] = new int[5];					//第二个一维数组中可以存储五个int值
		System.out.println("------------------");
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
	}
}
