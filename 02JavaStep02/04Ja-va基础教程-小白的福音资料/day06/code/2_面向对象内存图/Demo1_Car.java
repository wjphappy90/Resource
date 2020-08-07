class Demo1_Car {
	public static void main(String[] args) {
		Car c1 = new Car();				//创建对象

		//调用属性并赋值
		c1.color = "red";				//为车的颜色赋值
		c1.num = 8;						//为车的轮胎数赋值

		//调用行为
		c1.run();

		Car c2 = new Car();				//创建对象
		c2.color = "black";				//为车的颜色赋值
		c2.num = 4;						//为车的轮胎数赋值
		c2.run();

		//c2 = null;						//用null把原来的地址值覆盖掉了

		//c2.run();						//c2里面记录的是null,所以报出空指针异常

		Car c3 = c2;
		c3.run();
		
	}
}
/*
车的属性
	车的颜色
	车的轮胎数
车的行为
	车运行
*/

class Car {
	//成员变量
	String color;						//车的颜色
	int num;							//车的轮胎数

	public void run() {					//车运行
		System.out.println(color + "..." + num);
	}
}
