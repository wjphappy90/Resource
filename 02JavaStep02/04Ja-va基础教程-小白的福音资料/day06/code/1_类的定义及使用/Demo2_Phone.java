class Demo2_Phone {
	public static void main(String[] args) {
		//创建对象
		Phone p = new Phone();
		//调用对象中的属性并赋值
		p.brand = "锤子";
		p.price = 998;

		System.out.println(p.brand + "..."  + p.price);

		//调用成员方法
		p.call();
		p.sendMessage();
		p.playGame();
	}
}

/*
* 模仿学生类，让学生自己完成
	* 属性:品牌(brand)价格(price)
	* 行为:打电话(call),发信息(sendMessage)玩游戏(playGame)

*/
class Phone {
	String brand;					//品牌
	int price;						//价格

	public void call() {			//打电话
		System.out.println("打电话");
	}

	public void sendMessage() {		//发信息
		System.out.println("发信息");
	}

	public void playGame() {		//玩游戏
		System.out.println("玩游戏");
	}
}