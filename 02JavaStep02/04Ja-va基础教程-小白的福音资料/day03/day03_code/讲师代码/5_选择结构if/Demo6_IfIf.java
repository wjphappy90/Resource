/*
* A:案例演示
	* 需求：获取三个数据中的最大值
	* if语句的嵌套使用。
*/
class Demo6_IfIf {
	public static void main(String[] args) {
		int a = 40;
		int b = 50;
		int c = 30;
		
		if (a > b) {
			if (a > c) {
				System.out.println(a + "是最大值");
			}else {
				System.out.println(c + "是最大值");
			}

		}else {	//b >= a
			if (b > c) {
				System.out.println(b + "是最大值");
			}else {
				System.out.println(c + "是最大值");
			}
		}
	}
}
