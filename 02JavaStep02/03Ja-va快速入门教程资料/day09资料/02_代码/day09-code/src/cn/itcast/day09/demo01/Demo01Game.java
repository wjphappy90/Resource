package cn.itcast.day09.demo01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 扩展一点小知识：
 * 
 * 如何才能将一个字符串"100"转换成为int数字100？格式：
 * Integer.parseInt(String str)：参数是字符串，返回值是int数字，可以将字符串转换成为int数字。
 * 但是有前提：这个参数字符串必须只含有数字，格式必须是int数字！
 */
public class Demo01Game {
	
	public static void main(String[] args) throws IOException {
		// 1. 首先创建一个集合，用来存储五个英雄
		ArrayList<Hero> list = new ArrayList<>();
		
		// 2. 读文件，把数据加到集合当中。
		loadFileToList(list);
		
		// 3. 判断一下集合当中有没有内容，是不是新的？
		boolean isNew = list.size() == 0; // 如果集合的长度为0，说明这是新的队伍
		System.out.println("这是不是新队伍：" + isNew);
		
		// 如果是新的队伍，没有人，就需要创建五个对象加入到集合当中
		if (isNew) {
			// 调用方法，向集合当中添加五个英雄
			addFiveHeros(list);
		}
		// 如果队伍不是新的，已经有人了，就不需要创建了。
		
		System.out.println("我们队伍的阵容是：");
		// 遍历集合，输出其中的每一个对象的具体信息
		showHeros(list);
		
		// 统计一下总和战斗力是多少。
		int totalAttack = getTotalAttack(list); // 根据集合的内容求出总攻击力
		System.out.println("我们队伍的总战斗力是：" + totalAttack);
		
		// 判断一下集合是不是新的
		if (isNew) {
			saveToFile(list); // 调用方法将集合的信息写到文件中。
		}
		// 如果集合不是新的，而是从文件中加载得到的数据，就什么都不用做
		System.out.println("退出游戏");
	}
	
	/*
	 * 定义一个方法，用来读取文件，将数据添加到集合当中。三要素：
	 * 返回值类型：参数集合是引用类型，形式参数的操作会影响实际参数，所以void
	 * 方法名称：loadFileToList
	 * 参数列表：ArrayList<Hero>
	 */
	public static void loadFileToList(ArrayList<Hero> list) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("friends.txt"));
		
		String line; // 代表一行字符串
		while ((line = br.readLine()) != null) {
			// 需要将字符串转换成为一个Hero对象
			// 首先将一个完整的字符串切分成为若干小段儿
			String[] array = line.split(",");
			String name = array[0]; // 姓名
			// 将字符串转换成为对应的int基本类型数字
			int attack = Integer.parseInt(array[1]); // 攻击力
			String type = array[2]; // 类型
			// 根据三条信息创建一个英雄对象
			Hero hero = new Hero(name, attack, type);
			list.add(hero); // 将对象添加到集合当中
		}
		
		br.close(); // 不要忘记关闭流
	}
	
	/*
	 * 定义一个方法，用来将集合当中的对象数据全都写到文件里。三要素：
	 * 返回值类型：void
	 * 方法名称：saveToFile
	 * 参数列表：ArrayList<Hero>
	 */
	public static void saveToFile(ArrayList<Hero> list) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("friends.txt"));
		
		// 遍历集合，一个对象一个对象地挨个儿写
		for (int i = 0; i < list.size(); i++) {
			Hero hero = list.get(i); // 当前英雄
			// 需要将一个Hero对象转换成为字符串，将三个成员变量拼接成为一个字符串
			// 后羿,200,射手
			// 宫本武藏,14000,刺客
			// 机器人300,500,辅助
			String str = hero.getName() + "," + hero.getAttack() + "," + hero.getType();
			// 将对应的字符串写到文件中
			bw.write(str);
			bw.newLine(); // 不要忘记换行
		}
		
		// 最后关闭流
		bw.close();
	}
	
	/*
	 * 定义一个方法，用来根据集合求出战斗力总值。三要素：
	 * 返回值类型：int，代表结果总和
	 * 方法名称：getTotalAttack
	 * 参数列表：ArrayList<Hero>
	 */
	public static int getTotalAttack(ArrayList<Hero> list) {
		int total = 0; // 代表总攻击力
		for (int i = 0; i < list.size(); i++) {
			Hero hero = list.get(i);
			// 将每个英雄的战斗力全都累加到total当中
			total += hero.getAttack();
		}
		return total;
	}
	
	/*
	 * 定义一个方法，用来遍历集合当中所有对象的信息。三要素：
	 * 返回值类型：只是进行打印输出而已，所以使用void
	 * 方法名称：showHeros
	 * 参数列表：ArrayList<Hero>
	 */
	public static void showHeros(ArrayList<Hero> list) {
		for (int i = 0; i < list.size(); i++) {
			Hero hero = list.get(i); // 当前英雄
			System.out.println("英雄名字：" + hero.getName() + "，攻击力：" + hero.getAttack() + "，类型：" + hero.getType());
		}
	}
	
	/*
	 * 定义一个方法，用来向集合当中添加五位英雄。三要素：
	 * 返回值类型：参数集合是引用类型，形式参数的操作会影响实际参数，所以不需要返回值，void
	 * 方法名称：addFiveHeros
	 * 参数列表：ArrayList<Hero>
	 */
	public static void addFiveHeros(ArrayList<Hero> list) {
		// 英雄信息来自于键盘输入（Scanner）
		Scanner sc = new Scanner(System.in); // 创建一个Scanner用来进行键盘输入
		
		for (int i = 1; i <= 5; i++) { // 循环5次
			// 键盘输入英雄的三个信息
			System.out.println("请输入第" + i + "位英雄的姓名：");
			String name = sc.next(); // 获取字符串
			System.out.println("请输入第" + i + "位英雄的攻击力：");
			int attack = sc.nextInt(); // 获取int数字
			System.out.println("请输入第" + i + "位英雄的类型：");
			String type = sc.next();
			
			Hero hero = new Hero(name, attack, type); // 创建一个英雄对象
			list.add(hero); // 把英雄对象添加到集合当中
		}
	}

}
