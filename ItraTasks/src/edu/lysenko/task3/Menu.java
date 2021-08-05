package edu.lysenko.task3;

import static java.lang.System.lineSeparator;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Stream;

public class Menu {

	String getResultKeyHex(List<Integer> winners, List<Integer> loosers, int compMove, byte[] key) {
		return new StringBuilder(getResult(winners, loosers, compMove) + lineSeparator())
				.append(String.format("HMAC key: %02X", new BigInteger(1, key)) + lineSeparator()).toString();
	}

	String getResult(List<Integer> winners, List<Integer> loosers, int compMove) {
		return Stream.of("").map(result -> {
			if (loosers.contains(compMove)) {
				result = "You win";
			} else if (winners.contains(compMove)) {
				result = "You loss";
			} else {
				result = "Draw";
			}
			return result;
		}).findFirst().orElse("");
	}

	String getMenu(String encode) {
		return new StringBuilder(encode + lineSeparator())
				.append(lineSeparator() + "Available moves:" + lineSeparator()).append("1 - rock" + lineSeparator())
				.append("2 - paper" + lineSeparator()).append("3 - scissors" + lineSeparator())
				.append("4 - lizard" + lineSeparator()).append("5 - Spock" + lineSeparator())
				.append("0 - exit" + lineSeparator()).append("Enter you move: ").toString();
	}

	String getMoveResult(int compMove, int userMove) {
		return new StringBuilder().append(getMove("Computer", compMove) + lineSeparator())
				.append(getMove("You", userMove) + lineSeparator()).toString();
	}

	String getMove(String player, int condition) {
		return Stream.of(player).map(result -> {
			if (condition == 1 || condition % 5 == 1) {
				result = player + " move: rock ";
			} else if (condition == 2 || condition % 5 == 2) {
				result = player + " move: paper ";
			} else if (condition == 3 || condition % 5 == 3) {
				result = player + " move: scissors ";
			} else if (condition == 4 || condition % 5 == 4) {
				result = player + " move: lizard ";
			} else if (condition == 5 || condition % 5 == 0) {
				result = player + " move: Spock ";
			}
			return result;
		}).findFirst().orElse("");
	}
}