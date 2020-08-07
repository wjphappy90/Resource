class Demo3_Con {
	public static void main(String[] args) {
		Person p = new Person();
		//p.Person();
	}
}

class Person {
	//public void Person() {						//不是构造方法,是一个普通方法
	public Person() {
		System.out.println("Hello World!");
	}
}