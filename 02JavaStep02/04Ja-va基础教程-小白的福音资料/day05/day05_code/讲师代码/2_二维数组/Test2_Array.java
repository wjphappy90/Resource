/*
* A:案例演示
* 
		需求：公司年销售额求和
		某公司按照季度和月份统计的数据如下：单位(万元)
		第一季度：22,66,44
		第二季度：77,33,88
		第三季度：25,45,65
		第四季度：11,66,99
*/
class Test2_Array {
	public static void main(String[] args) {
		int[][] arr = {{22,66,44},{77,33,88},{25,45,65},{11,66,99}};

		int sum = 0;									//定义变量,记录每次相加的结果
		for (int i = 0;i < arr.length ;i++ ) {			//获取每一个一维数组
			for (int j = 0;j < arr[i].length ;j++ ) {	//获取每一个一维数组中的元素
				sum = sum + arr[i][j];					//累加
			}
		}

		System.out.println(sum);
	}
}
