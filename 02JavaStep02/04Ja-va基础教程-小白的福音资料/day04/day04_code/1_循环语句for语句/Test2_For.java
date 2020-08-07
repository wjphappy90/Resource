/*
* A:案例演示
	* 需求：求出1-10之间数据之和
* B:学生练习
	* 需求：求出1-100之间偶数和
	* 需求：求出1-100之间奇数和

	分析:1-10数据的和
	0 + 1
		1 + 2
			3 + 3
				6
				...
*/
class Test2_For {
	public static void main(String[] args) {
		//1-10的和
		/*int sum = 0;
		for (int i = 1;i <= 10 ;i++ ) {
			sum = sum + i;
		}

		System.out.println("sum = " + sum);*/

		//1-100的偶数和
		/*int sum = 0;
		for (int i = 1;i <= 100 ;i++ ) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
		}

		System.out.println("sum = " + sum);*/

		//1-100的奇数和
		int sum = 0;
		for (int i = 1;i <= 100 ;i+=2 ) {
			/*if (i % 2 != 0) {
				sum = sum + i;
			}*/
			sum = sum + i;
		}

		System.out.println("sum = " + sum);
	}
}
