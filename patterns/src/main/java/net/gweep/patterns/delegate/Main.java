package net.gweep.patterns.delegate;

public class Main {

	public static void main(String[] args) {
		Main m = new Main();
		System.out.println(m.show(new Phone()));
		System.out.println(m.show(new Tv()));
		System.out.println(m.show(new Device() {

			@Override
			public void show() {
				System.out.println("show default...");
			}
		}));
	}

	String show(Device device) {
		device.show();
		return device.getClass().getSimpleName();
	}
}