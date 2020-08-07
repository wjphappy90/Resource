package com.itheima.test02.demo01;

public class NoLifeValueExption extends RuntimeException {
	public NoLifeValueExption() {
		super();
	}

	public NoLifeValueExption(String message) {
		super(message);
	}
}
