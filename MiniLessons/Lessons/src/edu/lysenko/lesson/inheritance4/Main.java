package edu.lysenko.lesson.inheritance4;

public class Main extends ParentMain {

	@Override
	void show() {
		System.out.println("Main ");
	}

	public static void main(String[] args) {

		Main main = new Main();
		ParentMain parentMain = new ParentMain();
		ParentMain.result(main);
		ParentMain.result(parentMain);
	}
}

class ParentMain {

	void show() {
		System.out.println("ParentMain");
	}

	static void result(ParentMain pm) {
		pm.show();
	}

}