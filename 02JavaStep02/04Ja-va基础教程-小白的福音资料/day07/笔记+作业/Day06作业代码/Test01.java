public class Test01 {
	public static void main(String[] args) {
		Phone p = new Phone();		//创建手机类对象
		p.setBrand("IPhone");		//给手机的品牌赋值
		p.setPrice(6000);			//给手机的价格赋值
		System.out.println(p.getBrand() + "***" + p.getPrice());	//打印手机的信息
		p.call();					//调用手机类的call()方法
		p.sendMessage();			//调用手机类的sendMessage()方法
		p.playGame();				//调用手机类的playGame()方法
	}
}

class Phone {
	private String brand;		 //品牌
	private int price;			 //价格

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void call() {
		System.out.println("手机可以打电话");
	}

	public void sendMessage() {
		System.out.println("手机可以发短信");
	}

	public void playGame() {
		System.out.println("手机不能玩儿游戏");
	}
}
