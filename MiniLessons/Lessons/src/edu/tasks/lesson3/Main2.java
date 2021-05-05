package edu.tasks.lesson3;

public class Main2 {

	Degree degree;

	Main2(Degree degree) {
		this.degree = degree;
	}

	void show() {
		switch (degree) {
		case DOLLAR:
			System.out.println("DOLLAR");
			break;
		case RUB:
			System.out.println("RUB");
			break;
		default:
			System.out.println("Not money");
		}
	}

	public static void main(String[] args) {
		new Main2(Degree.DOLLAR).show();
		new Main2(Degree.RUB).show();
		new Main2(Degree.UAH).show();
//		System.out.println("main");
//		new T();
//		System.out.println("T complete");
//		new T(1);
//		System.out.println("T(1) complete");
		for (Degree degree : Degree.values()) {
			System.out.println("name: " + degree.name() + " ordinal:" + degree.ordinal());
		}

	}

}

class ChildT {

	ChildT(int p) {
		System.out.println(p);
	}
}

class T {
	ChildT childT;
	ChildT childT2;

	{
		childT = new ChildT(2);
		childT2 = new ChildT(4);
		System.out.println("childT && childT2");
	}

	T() {
		System.out.println("T");
	}

	T(int t) {
		System.out.println("T(int t)");
	}

}