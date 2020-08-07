package com.heima.枚举;

public abstract class Week3 {
	
	public static final Week3 MON = new Week3("星期一") {
		public void show() {
			System.out.println("星期一");
		}
	};
	public static final Week3 TUE = new Week3("星期二"){
		public void show() {
			System.out.println("星期二");
		}
	};
	public static final Week3 WED = new Week3("星期三"){
		public void show() {
			System.out.println("星期三");
		}
	};
	
	private String name;
	private Week3(String name){
		this.name = name;
	}						//私有构造,不让其他类创建本类对象
	public String getName() {
		return name;
	}
	
	public abstract void show();
}
