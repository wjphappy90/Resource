/*
* A:this关键字特点
	* 代表当前对象的引用 
* B:案例演示
	* this的应用场景
	* 用来区分成员变量和局部变量重名
*/
class Demo1_This {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("张三");
		p1.setAge(23);
		System.out.println(p1.getName() + "..." + p1.getAge());

		Person p2 = new Person();
		p2.setName("李四");
		p2.setAge(24);
		System.out.println(p2.getName() + "..." + p2.getAge());
	}
}

class Person {
	private String name;			//姓名
	private int age;				//年龄
	
	public void setAge(int age) {		//设置年龄
		if (age > 0 && age < 200) {
			this.age = age;
			//System.out.println(age);
		}else {
			System.out.println("请回火星吧,地球不适合你");
		}
		
	}

	public int getAge() {			//获取年龄
		return age;
	}

	public void setName(String name) {	//设置姓名
		this.name = name;
		//System.out.println(name);
	}

	public String getName() {
		return name;
	}
}