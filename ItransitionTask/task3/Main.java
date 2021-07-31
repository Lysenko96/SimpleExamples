package edu.lysenko.task3;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException {
		HMAC hmac = new HMAC();
		Menu menu = new Menu();
		Logic logic = new Logic();
		Scanner input = new Scanner(System.in);
		int steps = Integer.parseInt(args[0]);
		while (true) {
			if (steps >= 3 && steps % 2 != 0) {

				byte[] key = hmac.getKey();

				int compMove = new Random().nextInt(steps) + 1;

				String encode = hmac.getHMAC(key, compMove);

				Integer userMove = 0;
				String userMoveString = "";
				while (true) {
					try {
						userMove = Integer.parseInt(userMoveString);
						if (userMove instanceof Integer) {
							break;
						}
					} catch (NumberFormatException e) {
						while (true) {
							System.out.print(menu.getMenu(encode));
							userMoveString = input.nextLine();
							if (userMove instanceof Integer ) {
								break;
							}
						}
					}
				}

				if (userMove == 0) {
					break;
				}

				System.out.print(menu.getMoveResult(compMove, userMove));

				int diff = steps / 2;

				List<Integer> loosers = logic.getLoosers(userMove, diff);

				List<Integer> winners = logic.getWinners(userMove, diff);

				System.out.println(menu.getResultKeyHex(winners, loosers, compMove, key));

			} else {
				System.out.println("not correct, move >= 3 and move % 2 != 0");
				break;
			}
		}
		input.close();
	}
}