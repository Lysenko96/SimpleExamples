package edu.tasks.lambda1;

import static java.util.Collections.sort;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

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

		// predicate
		Predicate<Integer> predicate = (number) -> number % 2 == 0;
		System.out.println(predicate.test(10)); // true
		System.out.println(predicate.negate().test(4)); // false
		// function
		Function<Character, Integer> function = (ch) -> ch + '0';
		System.out.println(function.apply('Z')); // 138
		// supplier
		Supplier<Object> objectSupplier = Object::new;
		System.out.println(objectSupplier.get());
		// consumer
		Consumer<Car> consumer = (car) -> System.out
				.println("driver for " + car.getModel() + " with speed: " + car.getSpeed());
		consumer.accept(new Main().new Car("audi", 200));// driver for audi with speed: 200

		// optional
		Optional<Integer> optional = Optional.of(14);
		System.out.println(optional.isPresent());// true
		System.out.println(optional.get());// 14
		System.out.println(optional.orElse(null));// 14

		List<String> strings = asList("zz", "baa2", "bb", "zz1", "bdd", "dd4", "aa");
		// filter
		strings.stream().filter((s) -> s.startsWith("z")).forEach(System.out::println);
		// zz, zz1
		// sorted
		strings.stream().sorted().filter((s) -> s.startsWith("b")).forEach(System.out::println);
		// baa2, bb, bdd
		// map
		strings.stream().map((s) -> {
			return s.chars().average().getAsDouble();
		}).forEach(System.out::println);
		// 122.0, 85.5, 98.0, 97.66666666666667, 99.33333333333333, 84.0, 97.0

		// match
		System.out.println(strings.stream().anyMatch(s -> s.startsWith("a"))); // true

		// count
		System.out.println(strings.stream().filter(s -> s.startsWith("b")).count()); // 3

		// reduce
		Optional<String> reduced = strings.stream().sorted().reduce((s1, s2) -> s1 + "?" + s2);
		reduced.ifPresent(System.out::println); // aa?baa2?bb?bdd?dd4?zz?zz1

		Map<String, LocalDateTime> map = new HashMap<>();
		for (int i = 0; i < 10; i++) {
			map.putIfAbsent("date#" + (i + 1),
					LocalDateTime.of(2021 + i, Month.JANUARY.plus(i), 12 + i, 11 + i, 20 + i, 30 + i));
		}

		map.forEach((string, dateTime) -> System.out.println(string + ": " + dateTime));

		map.computeIfPresent("date#5", (str, dt) -> {
			char[] s = str.toCharArray();
			int n = 0;
			for (Character st : s) {
				n += (st + '0');
			}
			return LocalDateTime.of(2021 - n, Month.JANUARY.minus(n / 1000), 12 + n / 1000, 11 + n / 1000,
					20 + n / 1000, 30 + n / 1000);
		});
		System.out.println(map.get("date#5")); // 1231-01-12T11:20:30

		map.computeIfPresent("date#2", (str, dt) -> null);
		System.out.println(map.containsKey("date#2"));// false
		LocalDateTime ldt = map.computeIfAbsent("date#2",
				str -> LocalDateTime.of((("dd" + str).toCharArray()[0] + '0') / 10, Month.APRIL,
						(("dd" + str).toCharArray()[1] + '0') / 10, 0, 10, 3));// 0014-04-14T00:10:03

		System.out.println(map.containsKey("date#2")); // true
		map.remove("date#3", ldt);
		System.out.println(map.get("date#3")); // 2023-03-14T13:22:32
		map.remove("date#3", LocalDateTime.parse("2023-03-14T13:22:32"));
		System.out.println(map.get("date#3")); // null
		map.put("date#3", ldt);
		System.out.println(map.get("date#3")); // 0014-04-14T00:10:03
		System.out.println(map.get("date#2").equals(map.get("date#3")));// true date#2 equals date#3

		System.out.println(map.getOrDefault("xrc", LocalDateTime.now())); // today LocalDateTime

		// merge value in map

		Map<String, Integer> map1 = new HashMap<>();
		map1.put("ar", 11);
		map1.put("cd", 23);
		map1.merge("ar", 23, (value1, newValue) -> value1 + newValue);
		System.out.println(map1.get("ar"));// 11 + 23 = 34
		map1.merge("cd", 55, (value1, newValue) -> value1 + newValue);
		System.out.println(map1.get("cd"));// 23 + 55 = 78
		map1.merge("cd", 22, (value1, newValue) -> value1 + newValue);
		System.out.println(map1.get("cd"));// 22 + 78 = 100
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

	private class Car {

		private String model;
		private Integer speed;

		public Car() {

		}

		public Car(String model, Integer speed) {

			this.model = model;
			this.speed = speed;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public Integer getSpeed() {
			return speed;
		}

		public void setSpeed(Integer speed) {
			this.speed = speed;
		}

	}

}
