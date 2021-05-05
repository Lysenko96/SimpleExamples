package edu.lysenko.polymorphism2;

public class Main {

	public static void main(String[] args) {
		Super sup = new Sub();
		System.out.println("sup.temp=" + sup.temp + " sup.getTemp()=" + sup.getTemp());
		Sub sub = new Sub();
		System.out.println(
				"sub.temp=" + sub.temp + " sub.getTemp()=" + sub.getTemp() + " getSuperTemp()=" + sub.getSuperTemp());

	}

}

class Super {
	int temp;

	int getTemp() {
		return temp;
	}

}

class Sub extends Super {
	int temp = 1;

	int getTemp() {
		return temp;
	}

	int getSuperTemp() {
		return super.temp;
	}

}
