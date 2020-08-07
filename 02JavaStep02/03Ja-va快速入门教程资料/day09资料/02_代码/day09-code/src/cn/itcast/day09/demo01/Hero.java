package cn.itcast.day09.demo01;

// 自定义一个类，代表英雄
public class Hero {

	// 成员变量
	private String name; // 英雄的名字
	private int attack; // 英雄的攻击力
	private String type; // 英雄的类型

	public Hero() {
	}

	public Hero(String name, int attack, String type) {
		this.name = name;
		this.attack = attack;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
