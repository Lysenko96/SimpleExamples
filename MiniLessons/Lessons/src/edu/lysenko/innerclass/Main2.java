package edu.lysenko.innerclass;

import edu.lysenko.innerclass.Main2.Inner;

public class Main2 {

	public static void main(String[] args) {
		System.out.println(new NewClass().getInner());
	}

	static class Inner {

	}
}

class NewClass {

	private Inner inner = new Main2.Inner();

	public Inner getInner() {
		return inner;
	}

	public void setInner(Inner inner) {
		this.inner = inner;
	}
}
