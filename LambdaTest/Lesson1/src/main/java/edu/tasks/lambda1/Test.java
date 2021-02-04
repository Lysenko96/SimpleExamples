package edu.tasks.lambda1;

public class Test extends A1<Object> {

	private int number = 2;

	public Test(String name) {
		show(new A1<Object>().name = name);
		show(number);
	}

	public static void main(String[] args) {
		new Test("xzc"); // xzc 
	}                    // 2
}

class A1<T> {

	String name;

	public A1() {
	}

	public A1(String name) {
		this.name = name;
	}

	void show(T t) {
		System.out.println(t);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
