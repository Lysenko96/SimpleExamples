package edu.tasks.lambda1;

import static java.util.Collections.sort;

import java.util.List;

import static java.util.Arrays.asList;

public class Main {

	public static void main(String[] args) {
		Numerable length = (string) -> {
			if (string.length() % 2 == 0) {
				return true;
			}
			return false;
		};
		System.out.println(length.isEven("Hello"));
		System.out.println(length.isEven("Hello World!"));

		MyGeneric<String> reverser = (str) -> {
			char[] chars = str.toCharArray();
			String newStr = "";
			for (int i = chars.length - 1; i >= 0; i--) {
				newStr += chars[i];
			}
			return newStr;
		};
		System.out.println(reverser.calculate("SYNCHROPHASOTRON"));
		MyGeneric<Double> computer = (number) -> {
			number *= Math.PI;
			String[] numbers = number.toString().split("");
			return number % Double.valueOf(numbers[numbers.length - 1]);
		};

		List<Character> chars = asList('Z', 'd', 'L', 'p', 'c', 'k');

		sort(chars, (Character a, Character b) -> b.compareTo(a));

		System.out.println(chars);

		System.out.println(computer.calculate(35.34d));
		System.out.println(check(reverser, 2, "sd1f"));
		System.out.println(check(reverser, 2, 52.3d));
		
		
		
		
	}

	private static Integer check(MyGeneric ref, Integer value, Object obj) {
		if (obj instanceof String) {
			Object str = ref.calculate(obj);
			System.out.println(str);
			char[] chars = str.toString().toCharArray();
			Object number = chars[0] + '0' - chars[1] + '0' + chars[2] + '0';
			return Integer.valueOf(number.toString()) * value;
		} else if (obj instanceof Double) {
			return Integer.valueOf(obj.toString().replace(".", "0")) * value;
		}
		return 0;
	}

}
