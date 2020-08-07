/*
*	a:比较表达式无论简单还是复杂，结果必须是boolean类型
	* b:if语句控制的语句体如果是一条语句，大括号可以省略；
	  * 如果是多条语句，就不能省略。建议永远不要省略。
	* c:一般来说：有左大括号就没有分号，有分号就没有左大括号

*/
class Demo2_If {
	public static void main(String[] args) {
		int age = 17;

		if (age >= 18 && age <= 60) {
			System.out.println("可以浏览本网站");
			//int x = 10;				是两句话,int x声明是一句,x = 10 赋值是一句
		}
		System.out.println("完了");
		
	}
}
