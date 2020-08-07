/*
* A:循环结构do...while语句的格式：
* 
		do {
			循环体语句;
		}while(判断条件语句);
		
		完整格式；
		初始化语句;
		do {
			循环体语句;
			控制条件语句;
		}while(判断条件语句);
* B:执行流程：
	* a:执行初始化语句
	* b:执行循环体语句;
	* c:执行控制条件语句
	* d:执行判断条件语句,看其返回值是true还是false
		* 如果是true，就继续执行
		* 如果是false，就结束循环
	* e:回到b继续。
* C:案例演示
	* 需求：请在控制台输出数据1-10
*/
class Demo1_DoWhile {
	public static void main(String[] args) {
		//while 和do while的区别
		/*int i = 11;
		do {
			System.out.println("i = " + i);
			i++;
		}
		while (i <= 10);
		
		System.out.println("---------------------");

		int j = 11;
		while (j <= 10) {
			System.out.println("j = " + j);
			j++;
		}*/

		/*for (int i = 1;i <= 10 ;i++ ) {
			System.out.println("i = " + i);
		}

		//System.out.println("i = " + i);			for语句执行后变量会被释放,不能再使用
		System.out.println("-------------------");
		int i = 1;
		while (i <= 10) {
			System.out.println("i = " + i);
			i++;
		}
		System.out.println("-------------------");
		System.out.println("i = " + i);				//while语句执行后,初始化变量还可以继续使用*/

		//while语句的无限循环
		/*while (true) {
			System.out.println("hello world");
		}*/

		//System.out.println("hello world");
		//for语句的无限循环
		for (; ; ) {
			System.out.println("hello world");
		}
	}
}
