class Demo1_Code {
	public static void main(String[] args) {
		{
			int x = 10;						//限定变量的声明周期
			System.out.println(x);
		}
		
		Student s1 = new Student();
		System.out.println("---------------");
		Student s2 = new Student("张三",23);
	
	}

	static {
		System.out.println("我是在主方法类中的静态代码块");
	}
}

class Student {
	private String name;
	private int age;

	public Student(){
		//study();
		System.out.println("空参构造");
	}					//空参构造

	public Student(String name,int age) {//有参构造
		//study();
		this.name = name;
		this.age = age;
		System.out.println("有参构造");
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}

	{											//构造代码块:每创建一次对象就会执行一次,优先于构造函数执行
		//System.out.println("构造代码块");
		study();
	}

	public void study() {
		System.out.println("学生学习");
	}

	static {									//随着类加载而加载,且只执行一次
		System.out.println("我是静态代码块");	//作用:用来给类进行初始化,一般用来加载驱动
	}											//静态代码块是优先于主方法执行
}