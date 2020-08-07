class Demo5_Phone {
	public static void main(String[] args) {
		Phone p1 = new Phone();
		p1.setBrand("苹果");
		p1.setPrice(1500);
		System.out.println(p1.getBrand() + "..." + p1.getPrice());

		Phone p2 = new Phone("小米",98);
		p2.show();
	}
}
/*
手机类:
	成员变量:
		品牌brand,价格price
	构造方法
		无参,有参
	成员方法
		setXxx和getXxx
		show
*/
class Phone {
	private String brand;						//品牌
	private int price;							//价格

	public Phone(){}							//空参构造

	public Phone(String brand,int price) {		//有参构造
		this.brand = brand;
		this.price = price;
	}

	public void setBrand(String brand) {		//设置品牌
		this.brand = brand;
	}

	public String getBrand() {					//获取品牌
		return brand;
	}

	public void setPrice(int price) {			//设置价格
		this.price = price;
	}

	public int getPrice() {						//获取价格
		return price;
	}

	public void show() {
		System.out.println(brand + "..." + price);
	}
}