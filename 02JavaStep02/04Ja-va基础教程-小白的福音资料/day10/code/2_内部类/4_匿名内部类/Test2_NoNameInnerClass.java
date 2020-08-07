class Test2_NoNameInnerClass {
	public static void main(String[] args) {
		//Outer.method().show();			//链式编程,每次调用方法后还能继续调用方法,证明调用方法返回的是对象
		Inter i = Outer.method();
		i.show();
	}
}
//按照要求，补齐代码
interface Inter { 
	void show(); 
}

class Outer { 
	//补齐代码 
	public static Inter method() {
		return new Inter() {
			public void show() {
				System.out.println("show");
			}
		};
	}
}

//要求在控制台输出”HelloWorld”