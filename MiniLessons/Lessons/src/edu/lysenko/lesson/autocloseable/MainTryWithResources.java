package edu.lysenko.lesson.autocloseable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainTryWithResources {

	public static void main(String[] args) throws IOException {
		System.out.println(readLineBeforeEmpty(
				"/home/gweep/Documents/GitHub/SimpleExamples/MiniLessons/Lessons/src/edu/lysenko/lesson/autocloseable/file.txt"));
	}

	public static String readLineBeforeEmpty(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while (!br.readLine().isEmpty()) {
				return br.readLine();
			}
			return "";
		}
	}

}
