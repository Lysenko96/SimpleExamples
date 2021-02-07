package edu.task.filter;

public class ValueTest {

	public final String text = "text";

	public void doSomething() {
		String text = "text1";

		Runnable runnable = new Runnable() {
			public final String text = "text2";

			@Override
			public void run() {
				String text = "text4";
				System.out.println(this.text); // - text2 if System.out.println(text) - text4
			}
		};
		runnable.run();

		Thread thread = new Thread(() -> {
			System.out.println(this.text);
		}); // - text
		thread.run();
	}

	public static void main(String[] args) {
		ValueTest valueTest = new ValueTest();
		valueTest.doSomething();
	}
}
