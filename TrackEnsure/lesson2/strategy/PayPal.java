package te.lesson2.strategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PayPal implements PayStrategy {

	private static final Map<String, String> MEMORY = new HashMap<>();
	private static Scanner scanner = new Scanner(System.in);
	private String email;
	private String password;

	static {
		MEMORY.put("Anastasia", "anastasia97@gmail.com");
		MEMORY.put("Denis", "denis94@gmail.com");
	}

	@Override
	public boolean pay(int money) {
		if (email.equals(MEMORY.get(password))) {
			System.out.println("Paying " + money + " using PayPal.");
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void getInfo() {
		System.out.print("Enter email: ");
		email = scanner.nextLine();
		System.out.print("Enter password: ");
		password = scanner.nextLine();
		if (email.equals(MEMORY.get(password))) {
			System.out.println("Data verification successful...");
		} else {
			System.out.println("Wrong email or password!");
		}

	}

}
