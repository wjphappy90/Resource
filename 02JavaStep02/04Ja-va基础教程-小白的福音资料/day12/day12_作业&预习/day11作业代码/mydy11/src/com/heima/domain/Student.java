package com.heima.domain;
/**
 * 7.分析以下需求，并用代码实现：
 *	(1)在第5题创建的java项目myday11中，建立包com.heima.domain
 *	(1)在com.heima.domain包定义一个学生类Student，包含姓名(String name)、性别(String gender)、
 *		年龄(int age)、成绩(int score)，所有属性要私有
 *	(2)利用快捷键生成空参构造、有参构造、set方法、get方法、hashCode方法、toString方法、equals方法
 *	(3)分析Eclipse自动生成的equals方法的代码流程
 * @author JX
 *
 */
public class Student {
	//姓名属性
	private String name;
	//性别属性
	private String gender;
	//年龄属性
	private int age;
	//成绩属性
	private int score;
	//空参构造，快捷键alt+/ 后者alt+shift+s ->c
	public Student() {
		
	}
	//有参构造，快捷键alt+shift+s -> o ->回车
	public Student(String name, String gender, int age, int score) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.score = score;
	}
	//set和get方法，快捷键alt+shif+s -> r -> tab -> 回车 -> shift+tab —> 回车
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	//hashCode方法，快捷键alt+shif+s -> h -> 回车 
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + score;
		return result;
	}
	//equals方法，快捷键alt+shif+s -> h -> 回车 
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (age != other.age)
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (score != other.score)
			return false;
		return true;
	}
	
	//toString方法，快捷键alt+shift+s -> s
	public String toString() {
		return "Student [name=" + name + ", gender=" + gender + ", age=" + age
				+ ", score=" + score + "]";
	}	
}
