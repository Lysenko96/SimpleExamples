package edu.lysenko.lesson.inheritance;

public class C extends A {

	// private B b = new B();

	C(int a) {
		 super(a);
	}

	public static void main(String[] args) {
		new C(3);
		new B();
	}

}

class A {

	A() {
		System.out.println("go A ");
	}

	A(int c) {
		System.out.println("go A " + c);
	}
}

class B {

	private int b;

	B() {
		System.out.println("go B");
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

}