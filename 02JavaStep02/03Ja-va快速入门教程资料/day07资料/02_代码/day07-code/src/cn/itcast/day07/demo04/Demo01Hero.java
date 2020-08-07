package cn.itcast.day07.demo04;

import java.util.ArrayList;

public class Demo01Hero {
	
	public static void main(String[] args) {
		// 创建一个集合，代表一个队伍，里面有5个英雄
		ArrayList<Hero> team = new ArrayList<>();
		
		// 创建5个英雄对象
		Hero one = new Hero("蔡文姬", 200);
		Hero two = new Hero("貂蝉", 250);
		Hero three = new Hero("狄仁杰", 360);
		Hero four = new Hero("东皇太一", 150);
		Hero five = new Hero("韩信", 220);
		
		// 将5个英雄对象添加到集合中
		team.add(one);
		team.add(two);
		team.add(three);
		team.add(four);
		team.add(five);
		
		// 遍历集合，进行阵容展示
		for (int i = 0; i < team.size(); i++) {
			// 获取当前英雄
			Hero hero = team.get(i);
			System.out.println("英雄名称：" + hero.getName() + "，攻击力：" + hero.getAttack());
		}
	}

}
