package edu.lysenko.exceptions2;

public class ExceptionMain2 {

	void method1() throws MyException1 {
		try {
			throw new MyException1();
		} catch (MyException1 e) {
			try {
				throw new MyException2();
			} catch (MyException2 e2) {
				try {
					throw new MyException3();
				} catch (MyException3 e3) {
					throw e3;
				}
			}
		}
	}

	public static void main(String[] args) {
		ExceptionMain2 eMain2 = new ExceptionMain2();
		try {
			eMain2.method1();
		} catch (Exception e) {
			System.out.println("catch ");
		}
	}

}

class MyException1 extends ClassCastException {

}

class MyException2 extends ArrayIndexOutOfBoundsException {

}

class MyException3 extends NullPointerException {

}