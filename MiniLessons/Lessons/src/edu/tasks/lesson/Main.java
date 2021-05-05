package edu.tasks.lesson;

public class Main extends Main2 {

	private int x;
	private char c;
	private String s;

	// private static int a;

	@Override
	String getString(String str) {
		return super.getString(str) + addStr(s);
	}

	String addStr(String s) {
		return s;
	}

	String sterilize() {
		new Main2().setS("");
		return super.getString("");
	}

	Main(String s) {
		this.s = s;
//		System.out.println("int: " + x);
//		System.out.println("char: " + c);
//		System.out.println(new ATypeName());

	}

	public static void main(String[] args) {
		Main main = new Main(" Class Main");
//		System.out.println(main.getString(" Main: "));
		Main2.main(args);
		System.out.println(main.sterilize());
		System.out.println(main.sterilize());
		System.out.println(main.sterilize());
		// System.out.println(main.getString(" Main: "));

		// ATypeName type = new ATypeName();
		// ATypeName type2 = new ATypeName();
		// ATypeName type3 = new ATypeName();
		// type.d = 5;
		// type2.d = 6;
		// ATypeName.b = 3;
		// System.out.println(type);
		// System.out.println(type2);
		// System.out.println(type3);

	}
}

class ATypeName {

	int d;
	static int b;
	private String s;

	ATypeName() {
		System.out.println(s);
	}

	@Override
	public String toString() {
		return "ATypeName [d=" + d + " b=" + b + "]";
	}

}
