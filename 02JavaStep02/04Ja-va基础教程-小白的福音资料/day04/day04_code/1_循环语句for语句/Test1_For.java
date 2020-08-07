/*
* A:案例演示
	* 需求：请在控制台输出数据1-10
	* 需求：请在控制台输出数据10-1
* B:注意事项
	* a:判断条件语句无论简单还是复杂结果是boolean类型。
	* b:循环体语句如果是一条语句，大括号可以省略；如果是多条语句，大括号不能省略。建议永远不要省略。
	* c:一般来说：有左大括号就没有分号，有分号就没有左大括号
*/
class Test1_For {
	public static void main(String[] args) {
		for (int i = 1;i <= 10 ;i++ ){
			System.out.println("i = " + i);
		}
		System.out.println("-----------------------");

		for (int i = 10;i >= 1 ;i-- ) {
			System.out.println("i = " + i);
		}
	}
}
