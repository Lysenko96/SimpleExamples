package net.gweep.junit;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

	private Main main;
	private List<Directory> expected;
	private List<Directory> actual;
	private Directory root;

	@BeforeEach
	void setUp() {
		main = new Main();
		File file = new File("fileOne", LocalDateTime.now().minusMinutes(77));
		Directory subDir = new Directory("dirTwo", new Directory(), List.of(),
				List.of(new File("fileTwo", LocalDateTime.now())));
		List<File> files = new ArrayList<>();
		files.add(file);
		root = new Directory("dirOne", subDir, List.of(), files);
		expected = new ArrayList<>();
		expected.add(root);
		expected.add(subDir);
		actual = main.traverseInOrder(root, new ArrayList<>());
	}

	@Test
	void traverseInOrderDirTest() {
		assertEquals(expected, actual);
	}

	@Test
	void traverseInOrderFileTest() {
		List<File> expectedFiles = expected.stream().map(d -> {
			int count = 0;
			return d.getFiles().get(count++);
		}).collect(Collectors.toList());
		List<File> actualFiles = actual.stream().map(d -> {
			int count = 0;
			return d.getFiles().get(count++);
		}).collect(Collectors.toList());
		assertEquals(expectedFiles, actualFiles);
	}
}