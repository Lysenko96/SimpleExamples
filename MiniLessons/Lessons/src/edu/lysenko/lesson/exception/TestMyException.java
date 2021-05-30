package edu.lysenko.lesson.exception;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class TestMyException {

	TestMyException() throws IOException, ClassNotFoundException {
		System.out.println(catchException());
	}

	public static void main(String[] args) throws Throwable {
		new TestMyException();
	}

	private String catchException() throws IOException, ClassNotFoundException {
		try {
			return generateException();
		} catch (FileNotFoundException e) {
			return "file not found";
		}
	}

	private String generateException() throws IOException, ClassNotFoundException {
		if (new Random().nextBoolean()) {
			throw new ClassNotFoundException();
		} else {
			throw new FileNotFoundException();
		}
	}
}
