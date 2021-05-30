package edu.lysenko.iface4;

public class MainDefaultIface implements A, B{

	public MainDefaultIface() {
		mooA();
		mooB();
		moo();
	}

	public static void main(String[] args) {
		new MainDefaultIface();
	}

	@Override
	public void moo() {
		A.super.moo();
		B.super.moo();
	}

	void mooA() {
		A.super.moo();
	}

	void mooB() {
		B.super.moo();
	}

}

//interface A {
//
//	default void moo() {
//		System.out.println("A moo()");
//	}
//}
//
//interface B {
//
//	default void moo() {
//		System.out.println("B moo()");
//	}
//}
