/*
 * 学生类Student
			属性:语文成绩chinese，数学成绩math，英语成绩english
			行为:求总成绩的方法getSum()
 */
public class Test06 {
	public static void main(String[] args) {
		Student s = new Student();	//创建学生类对象
		s.setName("张三");	//给学员姓名赋值
		s.setChinese(99);	//给学员语文成绩赋值
		s.setMath(98);		//给学员数学成绩赋值
		s.setEnglish(60);	//给学员英语成绩赋值
		System.out.println(s.getName() + " 语文：" + s.getChinese() + "数学："+ s.getMath() + "英语："+ s.getEnglish() + "总分：" + s.getSum());//打印学员成绩
	}
}

class Student{
	private String name;//姓名
	private int chinese;//语文成绩
	private int math;//数学成绩
	private int english;//英语成绩
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getChinese() {
		return chinese;
	}
	public void setChinese(int chinese) {
		this.chinese = chinese;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEnglish() {
		return english;
	}
	public void setEnglish(int english) {
		this.english = english;
	}
	
	public int getSum() {		//求总成绩的方法
		return chinese + math +english ;
	}
}