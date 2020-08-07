/*
* A:案例演示
	* 需求：统计”水仙花数”共有多少个
	分析:
	1,需要有一个变量记录住水仙花数的个数
	2,获取到所有的3位数
	3,判断是否满足水仙花数
	4,如果满足条件,计数器就自增
*/
class Test4_FlowerCount {
	public static void main(String[] args) {
		int count = 0;

		for (int i = 100;i <= 999 ;i++ ) {
			int ge = i % 10;
			int shi = i / 10 % 10;
			int bai = i / 10 / 10;

			if (i == ge * ge * ge + shi * shi * shi + bai * bai * bai) {
				count ++;													//满足条件就自增,计数器思想
			}
		}

		System.out.println(count);
	}
}
