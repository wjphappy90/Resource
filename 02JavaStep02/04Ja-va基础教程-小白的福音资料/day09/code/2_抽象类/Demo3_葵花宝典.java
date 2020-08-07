class Demo3_葵花宝典 {
	public static void main(String[] args) {
		岳不群 小岳子 = new 岳不群();
		小岳子.自宫();
	}
}

abstract class 葵花宝典 {
	public abstract void 自宫();
}

class 岳不群 extends 葵花宝典 {
	public void 自宫() {
		System.out.println("用牙签");
	}
}

class 林平之 extends 葵花宝典 {
	public void 自宫() {
		System.out.println("用指甲刀");
	}
}

class 东方不败 extends 葵花宝典 {
	public void 自宫() {
		System.out.println("用锤子,不忍直视");
	}
}