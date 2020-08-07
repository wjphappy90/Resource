/*
* A:人类赋值年龄的问题
* B:private关键字特点
	* a:是一个权限修饰符
	* b:可以修饰成员变量和成员方法
	* c:被其修饰的成员只能在本类中被访问
* C:案例演示
	* 封装和private的应用：
	* A:把成员变量用private修饰
	* B:提供对应的getXxx()和setXxx()方法
	* private仅仅是封装的一种体现形式,不能说封装就是私有
*/
class Demo1_Person {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "张三";			//调用姓名属性并赋值
		//p1.age = -17;				//调用年龄属性并赋值
		//p1.speak();					//调用行为

		p1.setAge(-17);

		System.out.println(p1.getAge());
	}
}

class Person {
	String name;					//姓名
	private int age;				//年龄
	
	public void setAge(int a) {		//设置年龄
		if (a > 0 && a < 200) {
			age = a;
		}else {
			System.out.println("请回火星吧,地球不适合你");
		}
		
	}

	public int getAge() {			//获取年龄
		return age;
	}

	public void speak() {
		System.out.println(name + "..." + age);
	}
}