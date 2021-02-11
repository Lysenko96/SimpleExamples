package edu.task.streamapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import edu.task.behaviour.StringFormatter;
import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;

public class MainTwo {

	public static void main(String[] args) throws IOException {
		System.out.println(read());
	}

	public static String read() throws IOException {
		File file = new File(
				"/home/gweep/Documents/GitHub/SimpleExamples/StreamApiTest/streamLesson/src/main/resources/file.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			List<String> strings = reader.lines().collect(Collectors.toList());
			return formatter.listToString(strings);
		}

	}

	public static StringFormatter formatter = (strings) -> {
		return strings.stream().map(s -> {
			String text = "";
			return text += s;
		}).collect(joining(lineSeparator()));
	};
}
