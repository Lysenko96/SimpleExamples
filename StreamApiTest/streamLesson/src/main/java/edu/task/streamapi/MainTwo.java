package edu.task.streamapi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import edu.task.behaviour.BufferedReaderMachine;
import edu.task.behaviour.CarMaker;
import edu.task.behaviour.StringFormatter;
import edu.task.entity.Car;
import edu.task.filter.CarMakerImpl;

import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.*;

public class MainTwo {

	public static void main(String[] args) throws IOException {
		read();
		String lineOne = doingFile((BufferedReader r) -> r.readLine()); // put in interface input arg from this
																		// interface
		String lineOneAndTwo = doingFile((BufferedReader r) -> r.readLine() + " " + r.readLine());
		System.out.println(lineOne + lineSeparator() + lineOneAndTwo);
		System.out.println(new CarMakerImpl().makeCar(new Car("Audi", 322))); // model: Audi speed: 322
		System.out.println(getCarInfo((Car c) -> c.getModel() + lineSeparator() + c.getSpeed())); // Tesl 251
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
			System.out.println(strings.indexOf(s) + ": " + s); /*
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
}
