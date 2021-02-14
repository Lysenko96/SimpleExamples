package edu.task.streamapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import edu.task.behaviour.BufferedReaderMachine;
import edu.task.behaviour.CarMaker;
import edu.task.behaviour.Predicate;
import edu.task.behaviour.StringFormatter;
import edu.task.entity.Car;
import edu.task.filter.CarMakerImpl;

import static java.util.stream.Collectors.*;
import static java.lang.System.*;

public class MainTwo {

	public static void main(String[] args) throws IOException {
		read();
		String lineOne = doingFile((BufferedReader r) -> r.readLine()); // put in interface input arg from this
																		// interface
		String lineOneAndTwo = doingFile((BufferedReader r) -> r.readLine() + " " + r.readLine());
		out.println(lineOne + lineSeparator() + lineOneAndTwo);
		out.println(new CarMakerImpl().makeCar(new Car("Audi", 322))); // model: Audi speed: 322
		out.println(getCarInfo((Car c) -> c.getModel() + lineSeparator() + c.getSpeed())); // Tesl 251

		Predicate<Integer> nonZeroIntegerPredicate = (Integer n) -> n != 0;
		List<Integer> nonZero = filter(Arrays.asList(0, 2, 4, 0, 0, 1), nonZeroIntegerPredicate);
		out.println(nonZero);

		forEach(Arrays.asList("2u", "4r", "6y", "z8"), line -> out.println(line));

		Arrays.asList(1, 2).stream().forEach(out::println); // 1, 2
		forEachNew(3, out::println); // 3
		Map<Integer, Integer> mInt = new HashMap<>();
		mInt.put(-22, 534);
		mInt.put(236, 134);
		Map<Character, Character> mCh = map(mInt, (Integer i) -> intToChar(i));
		out.println(mCh); // {￪=Ȗ, ì=}
	}

	public static Character intToChar(Integer i) {
		int i1 = i;
		char c = (char) i1;
		return c;
	}

	public static void read() throws IOException {
		File file = new File(
				"/home/gweep/Documents/GitHub/SimpleExamples/StreamApiTest/streamLesson/src/main/resources/file.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			List<String> strings = reader.lines().collect(toList());
			formatter.listToString(strings);
		}

	}

	public static StringFormatter formatter = (strings) -> {
		return strings.stream().map(s -> {
			out.println(strings.indexOf(s) + ": " + s); /*
														 * 0: 1.txt 1: file.txt 2: x 3: z 4: t
														 */
			return s;
		}).collect(joining(lineSeparator()));
	};

	public static String doingFile(BufferedReaderMachine machine) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(
				"/home/gweep/Documents/GitHub/SimpleExamples/StreamApiTest/streamLesson/src/main/resources/file.txt"));
		return machine.doing(reader);
	}

	public static String getCarInfo(CarMaker carMaker) {
		return carMaker.makeCar(new Car("Tesla", 251));
	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T s : list) {
			if (p.test(s)) {
				result.add(s);
			}
		}
		return result;
	}

	public static <T> void forEach(List<T> items, Consumer<T> c) {
		for (T item : items) {
			c.accept(item);
		}
	}

	public static <T> void forEachNew(Integer i, Consumer<T> c) {
		c.accept((T) i);
	}

	public static <T, R> Map<R, R> map(Map<T, T> m, Function<T, R> f) { // get map with one type and return with other
																		// type
		Map<R, R> result = new HashMap<>();
		for (Map.Entry<T, T> pair : m.entrySet()) {
			result.put(f.apply(pair.getKey()), f.apply(pair.getValue()));
		}
		return result;
	}
}
