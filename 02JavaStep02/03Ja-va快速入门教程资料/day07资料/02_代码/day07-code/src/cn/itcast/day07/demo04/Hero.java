package cn.itcast.day07.demo04;

public class Hero {

	private String name; // Ãû×Ö
	private int attack; // ¹¥»÷Á¦

	public Hero() {
	}

	public Hero(String name, int attack) {
		this.name = name;
		this.attack = attack;
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

}
