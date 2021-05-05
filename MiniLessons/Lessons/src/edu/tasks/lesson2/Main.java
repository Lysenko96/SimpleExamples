package edu.tasks.lesson2;

public class Main {

	public Main() {
		System.out.println("message");
	}

	Main(String s) {
		System.out.println(s + "message");
	}

	public static void main(String[] args) {
		new Main();
		new Main("hello ");
		Dog dog = new Dog();
		System.out.println(dog.bark(" vaf", 4));
		System.out.println(dog.bark(5, "gav "));
		new Cat().increment().increment();
		System.out.println();
		new Cat().show();
		System.out.println();
		new Constructor("str", 3);
		make();
	}

	static void make() {
		System.out.println("check2");
	}

	public void check() {
		make();
	}

}

class Constructor {

	int a;
	String s;

	Constructor(String s, int a) {
		this(a);
		this.s = s;
		System.out.println("constr1: " + s + " int: " + a);
	}

	Constructor(int a) {
		this.a = a;
		System.out.println("const2: " + a);
	}
}

class Cat {

	int i;

	Cat increment() {
		System.out.print(i + " ");
		i++;
		return this;
	}

	void show() {
		this.increment();
		increment();
		System.out.print(i);
	}

}

class Dog {

	String bark(String s, int a) {
		return a + s;
	}

	String bark(int a, String s) {
		return s + a;
	}

}