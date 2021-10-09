package net.gweep.junit;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

	private Main main;

	@BeforeEach
	void setUp() {
		main = new Main();
	}

	@Test
	void traverseInOrderTest() {
		File file = new File("fileOne", LocalDateTime.now().minusMinutes(77));
		Directory subDir = new Directory("dirTwo", new Directory(), List.of(),
				List.of(new File("fileTwo", LocalDateTime.now())));
		Directory root = new Directory("dirOne", subDir, List.of(), List.of(file));
		List<Directory> expected = new ArrayList<>();
		expected.add(root);
		expected.add(subDir);
		assertEquals(expected, main.traverseInOrder(root, new ArrayList<>(), new ArrayList<>()));
		List<File> filesExpected = new ArrayList<>();
		List<File> filesActual = new ArrayList<>();
		for (Directory dir : expected) {
			for (File f : dir.getFiles()) {
				filesExpected.add(f);
			}
		}
		for (Directory dir : main.traverseInOrder(root, new ArrayList<>(), new ArrayList<>())) {
			for (File f : dir.getFiles()) {
				filesActual.add(f);
			}
		}
		assertEquals(filesExpected, filesActual);

	}

}