package edu.lysenko.iface4;

public interface A {

	default void moo() {
		System.out.println("A moo()");
	}
}
