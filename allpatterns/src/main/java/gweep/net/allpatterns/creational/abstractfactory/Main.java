package gweep.net.allpatterns.creational.abstractfactory;

public class Main {

	public static void main(String[] args) {
		new Bank().createBank();
		System.out.println();
		new Tesla().createTesla();
	}
}
