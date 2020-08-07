package cn.itcast.day06.demo06;

/*
 * 对于所有的数据类型，Getter都必须叫getXxx，Setter都必须叫setXxx，但是有一个特例。
 * 如果是基本数据类型当中的boolean值，那么setXxx规则不变，而getXxx需要写成isXxx的形式。
 */
public class Person {

	private String name; // 姓名
	private int age; // 年龄
	private boolean male; // 是不是爷们儿，true代表爷们儿，false代表不是爷们儿

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
