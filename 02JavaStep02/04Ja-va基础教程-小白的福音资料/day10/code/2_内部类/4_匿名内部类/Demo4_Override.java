class Demo4_Override {
	public static void main(String[] args) {
		
	}
}

class Person {
	public void print() {
		System.out.println("Person");
	}
}

class Student extends Person {
	public void print() {
		System.out.println("Student");
	}
}

class Father { 
	public Person method() {
		return new Person();
	}
}

class Son extends Father {
	public Student method() {
		return new Student();
	}
}

