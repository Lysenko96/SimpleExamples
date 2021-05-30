package edu.lysenko.iface4;

public interface B {

	default void moo() {
		System.out.println("B moo()");
	}
}
