package com.itheima.annotation;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("all")
public class AnnotationTest {

	@Override
	public String toString() {
		return super.toString();
	}

	@Deprecated
	public static void show() {

	}

	public static void main(String[] args) {
		// show();

		// Date date=new Date();

		// date.toLocaleString();

		// @SuppressWarnings("rawtypes")
		List list = new ArrayList();
		System.out.println(list);

		int a = 10;

	}
}

interface A {

	public void show();
}

class B implements A {

	@Override
	public void show() {

	}

}
