class Student {
	static {
		System.out.println("Student 静态代码块");
	}
	
	{
		System.out.println("Student 构造代码块");
	}
	
	public Student() {
		System.out.println("Student 构造方法");
	}
}

class Demo2_Student {
	static {
		System.out.println("Demo2_Student静态代码块");
	}
	
	public static void main(String[] args) {
		System.out.println("我是main方法");
		
		Student s1 = new Student();
		Student s2 = new Student();
	}
}