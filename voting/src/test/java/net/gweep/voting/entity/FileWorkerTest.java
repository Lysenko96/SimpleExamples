package net.gweep.voting.entity;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.gweep.voting.fileworker.FileWorker;

class FileWorkerTest {

	FileWorker fileWorker;
	List<Object> letters;

	@BeforeEach
	void setUp() {
		fileWorker = new FileWorker();
		letters = List.of("Hello world");
	}

	@Test
	void writeObjectsTest() {
		File file = new File("input.txt");
		if (!file.exists()) {
			try {
				file.createNewFile();
				fileWorker.writeObjects(letters, file.getPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		char[] array = new char[100];
		try (Reader input = new FileReader("input.txt")) {
			input.read(array);
		} catch (IOException e) {
			e.printStackTrace();
		}
		StringBuilder sb = new StringBuilder();
		for (Character c : array) {
			sb.append(c);
		}
		System.out.println("write: " + letters.get(0));
		System.out.println("read: " + sb.toString());
		assertEquals(letters.get(0), sb.toString().trim());
	//	file.delete();
	}
}
