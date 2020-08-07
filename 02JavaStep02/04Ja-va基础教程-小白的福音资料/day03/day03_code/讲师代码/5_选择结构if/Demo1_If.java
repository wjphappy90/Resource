/*
* C:if语句的格式1
* 
		if(比较表达式) {
			语句体;
		}
* D:执行流程：
	* 先计算比较表达式的值，看其返回值是true还是false。
	* 如果是true，就执行语句体；
	* 如果是false，就不执行语句体；
*/
class Demo1_If {
	public static void main(String[] args) {
		int age = 17;

		if (age >= 18) {
			System.out.println("可以浏览本网站");
		}

		System.out.println("完了");
	}
}
