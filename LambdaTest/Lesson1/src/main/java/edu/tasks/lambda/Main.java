package edu.tasks.lambda;

public class Main {

	private static MyClass myClass = new MyClass();

	public static void main(String[] args) {
		System.out.println(square.calculate(3));
		String str = addition.addString("Hello ");
		System.out.println(str);
		str += addition.addString("World!");
		System.out.println(str);
		System.out.println(object.retrieve(new Object()));
		// return getStatic with args
		Classable ref = myClass::getStatic;
		// return getStatic without args
		Emtyble ref1 = myClass::getStatic;
		Object obj = new Object();
		System.out.println(obj);
		System.out.println(ref.getObject(obj));
		System.out.println(ref1.getObject());
	}

	public static Calculable square = (number) -> {
		Integer value = number * number;
		return value;
	};

	public static Appendable addition = (string) -> {
		String value = "";
		value += string;
		return value;
	};

	public static MyInterface object = (object) -> {
		return object = new Object();
	};
}
