package edu.task.streamapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import edu.task.behaviour.StringFormatter;
import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.*;

public class MainTwo {

	public static void main(String[] args) throws IOException {
		read();
	}

	public static String read() throws IOException {
		File file = new File(
				"/home/gweep/Documents/GitHub/SimpleExamples/StreamApiTest/streamLesson/src/main/resources/file.txt");
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			List<String> strings = reader.lines().collect(toList());
			return formatter.listToString(strings);
		}

	}

	public static StringFormatter formatter = (strings) -> {
		return strings.stream().map(s -> {
			System.out.println(strings.indexOf(s) + ": " + s);  /* 0: 1.txt 
																 * 1: file.txt 
																 * 2: x 
																 * 3: z 
																 * 4: t */
			return s;
		}).collect(joining(lineSeparator()));
	};
}
