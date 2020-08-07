class Demo7_Phone {
	public static void main(String[] args) {
		Ios8 i = new Ios8();
		i.siri();
		i.call();
	}
}

/*
B:方法重写的应用：
	* 当子类需要父类的功能，而功能主体子类有自己特有内容时，可以重写父类中的方法。这样，即沿袭了父类的功能，又定义了子类特有的内容。
	ios7系统 siri speak English
	ios8系统 siri 说中文
*/

class Ios7 {
	public void call() {
		System.out.println("打电话");
	}

	public void siri() {
		System.out.println("speak English");
	}
}

class Ios8 extends Ios7 {
	public void siri() {
		
		System.out.println("说中文");
		super.siri();
	}
}