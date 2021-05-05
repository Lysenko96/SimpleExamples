package edu.tasks.lesson3;

public class Main {

	public Main() {

	}

	public static void main(String[] args) {
		CallStatic.call.f(33);
		new Test();
		System.out.println("-----");
		new Test(1);

	}

	public void check() {
		System.out.println("check3");
	}
}

class Data {

	// int d;

	Data() {
		System.out.println("Data()");
	}

	Data(int d) {
		// this.d = d;
		System.out.println("Data(int d) " + d);
	}
}

class Call {
	void f(int number) {
		System.out.println(number);
	}
}

class CallStatic {
	static Call call;
	static {
		call = new Call();
	}
}

class Test {

	Test() {
		System.out.println("Test()");
		d1 = new Data(2);
		System.out.println(d1);
	}

	Test(int a) {
		System.out.println("Test(int a)");
		System.out.println(d2);
	}

	Data d2 = new Data();
	static Data d1 = new Data(33);

}
