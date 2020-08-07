class Demo2_Phone {
	public static void main(String[] args) {
		Phone p1 = new Phone();
		p1.setBrand("三星");
		p1.setPrice(5288);

		System.out.println(p1.getBrand() + "..." + p1.getPrice());
		p1.call();
		p1.sendMessage();
		p1.playGame();
	}
}
/*
手机类
	属性:品牌brand,价格price
	行为:打电话call,发短信sendMessage,玩游戏,playGame
*/
class Phone {								//java bean
	private String brand;					//品牌
	private int price;						//价格

	public void setBrand(String brand) {	//设置品牌
		this.brand = brand;
	}

	public String getBrand() {				//获取品牌
		return this.brand;					//this.可以省略,你不加系统会默认给你加
	}

	public void setPrice(int price) {		//设置价格
		this.price = price;
	}

	public int getPrice() {					//获取价格
		return price;
	}

	public void call() {					//打电话
		System.out.println("打电话");
	}

	public void sendMessage() {				//发短信
		System.out.println("发短信");
	}

	public void playGame() {				//玩游戏
		System.out.println("玩游戏");
	}
}