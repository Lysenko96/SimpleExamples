package edu.lysenko.lesson.inheritance;

public class Overload extends MultiMethod {

	int getArgs(String s) {
		return Integer.valueOf(s);
	}

	public static void main(String[] args) {

		MultiMethod multiMethod = new MultiMethod();
		System.out.println(multiMethod.getArgs());
		System.out.println(multiMethod.getArgs(3));
		System.out.println(multiMethod.getArgs(8, "y"));
		Overload overload = new Overload();
		System.out.println(overload.getArgs("2"));
	}
}

class MultiMethod {

	int getArgs() {
		return 0;
	}

	int getArgs(int a) {
		return a;
	}

	int getArgs(int a, String s) {
		return a + s.charAt(0);
	}
}
