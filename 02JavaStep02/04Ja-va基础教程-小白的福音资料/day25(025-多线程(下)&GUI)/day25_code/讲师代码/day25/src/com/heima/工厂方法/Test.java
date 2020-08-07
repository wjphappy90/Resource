package com.heima.工厂方法;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DogFactory df = new DogFactory();
		Dog d = (Dog) df.createAnimal();
		d.eat();
	}

}
