package edu.tasks.streamapi;

import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Arrays.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;

import static java.lang.System.out;

public class Main {

	public Main() throws IOException {
		getStream(asList()).forEach(out::println);
		getStream(asList("hello", "world!")).forEach(out::println); // hello world!
		Collection<Integer> collection = asList(55, 23);
		collection.stream().forEach(out::println); // 55, 23
		Character[] chars = new Character[] { 'x', 'y', 'z' };
		Stream<Character> streamChars = stream(chars, 2, 3);
		streamChars.forEach(out::println); // z
		Stream<Integer> s = Stream.<Integer>builder().add(34).build();
		s.forEach(out::println);
		Stream.generate(() -> "text").limit(5).forEach(out::println); // text 5 word
		Stream.iterate(22.2d, x -> x * 1.6d).limit(4).forEach(out::println); // 22.2, 35.52, 56.83200000000001,
																				// 90.93120000000002
		IntStream.range(2, 4).forEach(out::println); // 2,3
		Random rand = new Random();
		rand.doubles(2).forEach(out::println); // 0.5611378662576689, 0.22104158134198149

		IntStream myStreamChars = "text".chars();
		myStreamChars.forEach(out::println);// 116 101 120 116
		Pattern.compile(",").splitAsStream("c,d").forEach(out::println); // c,d

		Path path = Paths.get("/home/gweep/eclipse-workspace/streamapi/src/main/resources/file"); // absolute_path_to_file
		Files.lines(path).forEach(out::println); // hello world! - data in file

	}

	public static void main(String[] args) throws IOException {
		new Main();
	}

	public Stream<String> getStream(List<String> list) {
		if (list == null || list.isEmpty())
			return Stream.empty();
		return list.stream();
	}
}
