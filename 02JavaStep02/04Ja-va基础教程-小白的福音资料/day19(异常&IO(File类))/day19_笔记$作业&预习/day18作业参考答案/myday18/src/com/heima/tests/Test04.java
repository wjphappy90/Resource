package com.heima.tests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 4.分析以下需求，并用代码实现：
 *	(1)定义一个学生类Student，属性：姓名(String name)、班级班号(String no)、成绩(double score)
 *	(2)将若干Student对象存入List集合，并统计每个班级的总分和平均分
 *		思路：
 *			a.采用面向对象的思想
 *			b.不推荐使用Map<String,List<Student>> 操作不方便
 *			c.推荐使用Map<String，ClassRoom>
 * @author JX
 *
 */
public class Test04 {
	public static void main(String[] args) {
		//1.考试
		List<Student> stuList = exam();
		//2.分析成绩
		Map<String,ClassRoom> map = count(stuList);
		//3.查看成绩(总分,平均分)
		view(map);
	}
	/**
	 * 查看每个班的总分和平局分
	 */
	public static void view(Map<String,ClassRoom> map){
		Set<String> keys = map.keySet();
		//获取迭代器
		Iterator<String> keysIt = keys.iterator();
		//先判断
		while(keysIt.hasNext()){
			//再获取
			String no = keysIt.next();
			ClassRoom room = map.get(no);
			//查看总分 计算平均分
			double total = room.getTotal();
			double avg = total/room.getStuList().size();
			System.out.println(no+"-->"+total+"-->"+avg);
		}
		
	}
	/**
	 * 统计分析
	 */
	public static Map<String,ClassRoom> count(List<Student> list){
		Map<String,ClassRoom> map = new HashMap<String,ClassRoom>();
		//1.遍历List
		for(Student stu:list){
			//分拣 查看是否存在该编号的班级
			String no = stu.getNo();//班级编号
			double score = stu.getScore();//成绩
			//如果不存在,创建班级
			ClassRoom room = map.get(no);
			if(null == room){
				room = new ClassRoom(no);
				map.put(no, room);
			}
			//存在,放入学生
			room.getStuList().add(stu);//放入学生
			room.setTotal(room.getTotal()+score);//计算总分
			
		}
		return map;
		
	}
	/**
	 * 模拟考试 测试数据放到List中
	 */
	public static List<Student> exam(){
		List<Student> list = new ArrayList<Student>();
		//存放学生成绩
		list.add(new Student("灭绝师太","Android",80));
		list.add(new Student("刘德华","Android",70));
		list.add(new Student("张惠妹","Android",60));
		list.add(new Student("黄健翔","Android",90));
		list.add(new Student("刘翔","JavaEE",85));
		list.add(new Student("周星驰","JavaEE",65));
		list.add(new Student("马云","JavaEE",70));
		list.add(new Student("马化腾","JavaEE",50));
		return list;
		
	}
}
//定义学生类
class Student {
	private String name;//姓名
	private String no;//班级编号
	private double score;//成绩
	public Student() {
		
	}
	public Student(String name, String no, double score) {
		super();
		this.name = name;
		this.no = no;
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}	
}
//定义班级类(一个班级有多个学生)
class ClassRoom {
	private String no;//班级
	private List<Student> stuList;//班级列表
	private double total;//总分
	public ClassRoom() {
		stuList = new ArrayList<Student>();
	}
	public ClassRoom(String no) {
		this();
		this.no = no;
	}
	public ClassRoom(String no, List<Student> stuList, double total) {
		super();
		this.no = no;
		this.stuList = stuList;
		this.total = total;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public List<Student> getStuList() {
		return stuList;
	}
	public void setStuList(List<Student> stuList) {
		this.stuList = stuList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}	
}
