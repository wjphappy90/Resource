class Demo1_Switch {
	public static void main(String[] args) {
		/*
		* A:switch语句的格式
		*		int x = 10;
				switch(表达式) {		//基本数据类型可以接收byte,short,char,int
					  case 值1：		//引用数据类型可以接收枚举(JDK1.5)String字符串(JDK1.7)
						语句体1;
						break;
						case 值2：
						语句体2;
						break;
						…
						default：	
						语句体n+1;
						break;
				}
		 
		* B:switch语句的格式解释
		* C:面试题
			* byte可以作为switch的表达式吗?
			* long可以作为switch的表达式吗?
			* String可以作为switch的表达式吗?
		* C:执行流程
			* 先计算表达式的值
			* 然后和case后面的匹配，如果有就执行对应的语句，否则执行default控制的语句
		*/

		String name = "rose";
		String gender = "妖";
		switch (gender) {
		case "男士":
			System.out.println(name + "是一位" + gender + "喜欢吃饭睡觉打dota");
		break;
		case "女士":
			System.out.println(name + "是一位" + gender + "喜欢逛街购物美容");
		break;
		default:
			System.out.println(name + "是一位" + gender + "打雌性激素维持美貌容颜");
		break;
		}
	}
}
