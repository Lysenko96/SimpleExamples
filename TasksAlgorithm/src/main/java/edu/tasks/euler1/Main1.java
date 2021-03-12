package edu.tasks.euler1;

//Largest prime factor 600851475143l answer  6857

public class Main1 {

	Main1() {
		long f = 1;
		int i = 1;
		while (f <= 600851475143l) {
			if (600851475143l % i == 0) {
				System.out.println(i);
				f *= i;
				System.out.println("f " + f);
			}
			i++;

		}
	}

	public static void main(String[] args) {
		new Main1();
	}

}
