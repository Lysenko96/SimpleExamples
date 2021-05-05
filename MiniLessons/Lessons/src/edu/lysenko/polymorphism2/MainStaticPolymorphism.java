package edu.lysenko.polymorphism2;

public class MainStaticPolymorphism {

	public static void main(String[] args) {
		StaticSuper sup = new StaticSub();
		StaticSub sub = new StaticSub();
		sup.show();
		// static method not use polymorphism
		sup.showStatic();
		sub.show();
		sub.showStatic();
	}
}

class StaticSuper {

	static void showStatic() {
		System.out.println("super showStatic");
	}

	void show() {
		System.out.println("super show");
	}

}

class StaticSub extends StaticSuper {

	static void showStatic() {
		System.out.println("sub showStatic");
	}

	@Override
	void show() {
		System.out.println("sub showStatic");
	}

}