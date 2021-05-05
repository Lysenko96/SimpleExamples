package edu.lysenko.abstractclass;

public class Main {

	public static void main(String[] args) {
		SubClass subClass = new SubClass();
		System.out.println(subClass.print());
	}
}

abstract class BaseClass {

	BaseClass() {
		System.out.println(print());
	}

	abstract int print();

}

class SubClass extends BaseClass implements IFace {

	private int i = 2;

	@Override
	int print() {
		return i;
	}

	@Override
	public void show() {

	}

}
