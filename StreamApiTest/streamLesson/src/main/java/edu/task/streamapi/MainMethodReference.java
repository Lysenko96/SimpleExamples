package edu.task.streamapi;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

import static java.lang.System.out;

public class MainMethodReference {

	public static void main(String[] args) {

		List<Double> digits = asList(20.3d, 31.8d, 11.7d, 26.1d);
		digits.sort((n1, n2) -> n2.compareTo(n1));
		out.println(digits); // [31.8, 26.1, 20.3, 11.7]
		digits.sort((Double::compareTo));
		out.println(digits); // [11.7, 20.3, 26.1, 31.8]

		Function<String, Character> stringToCharacter = (String s) -> method(s);
		out.print(stringToCharacter.apply("./run.sh")); // л
	}

	public static char method(String s) {
		char[] chars = s.toCharArray();
		return Stream.of(chars).map((string) -> {
			int number = 0;
			for (char symbol : string) {
				number += symbol + '0';
			}
			return (char) number;
		}).collect(Collectors.toList()).get(0);
	}
}
