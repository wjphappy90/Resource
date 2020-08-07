/*
* A:案例演示
	* 需求：请输出一个4行5列的星星(*)图案。
	* 
			如图：
				*****
				*****
				*****
				*****
				
			注意：
				System.out.println("*");和System.out.print("*");的区别
* B:结论：
	* 外循环控制行数，内循环控制列数
*/
class Demo1_ForFor {
	public static void main(String[] args) {
		/*for (int i = 1;i <= 3 ;i++ ) {					//外循环
			System.out.println("i = " + i);
			for (int j = 1;j <= 3 ;j++ ) {				//内循环
				System.out.println("j = " + j);
			}
		}*/

		for (int i = 1;i <= 4 ;i++ ) {					//外循环决定的是行数
			for (int j = 1;j <= 5 ;j++ ) {				//内循环决定的是列数
				System.out.print("*");
			}
			System.out.println();
		}
	}
}

/*
*****
*****
*****
*****

*/
