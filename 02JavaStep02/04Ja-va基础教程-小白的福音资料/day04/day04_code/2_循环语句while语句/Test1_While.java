class Test1_While {
	public static void main(String[] args) {
		/*
		* A:求和思想
			* 求1-100之和
		* B:统计思想
			* 统计”水仙花数”共有多少个
		*/
		
		//求1-100之和
		/*int sum = 0;
		int i = 1;
		while (i <= 100) {
			sum += i;					//sum = sum + i;
			i++;						//让变量i自增
		}

		System.out.println("sum = " + sum);*/

		//统计”水仙花数”共有多少个
		int count = 0;					//计数器
		int i = 100;
		while (i <= 999) {
			int ge = i % 10;
			int shi = i / 10 % 10;
			int bai = i / 100;

			if (i == ge * ge * ge + shi * shi * shi + bai * bai * bai) {
				count ++;
			}

			i++;
		}

		System.out.println("count =" + count);

		//某屌丝为了追求女神,写了一段代码示爱,但是女神也会java,改动一下把屌丝拒绝
		int j = 1;
		while (j <= 10000) {
			System.out.println("I Love You!!!");
			j++;
		}
	}
}
