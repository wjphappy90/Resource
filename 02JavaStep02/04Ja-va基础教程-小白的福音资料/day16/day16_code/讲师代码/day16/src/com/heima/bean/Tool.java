package com.heima.bean;

public class Tool<Q> {
	private Q q;

	public Q getObj() {
		return q;
	}

	public void setObj(Q q) {
		this.q = q;
	}
	
	public<T> void show(T t) {				//方法泛型最好与类的泛型一致
		System.out.println(t);				//如果不一致,需要在方法上声明该泛型
	}
	
	public static<W> void print(W w) {		//静态方法必须声明自己的泛型
		System.out.println(w);
	}
	
}
