package gweep.net.allpatterns.structural.composite2;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

	private List<Directory> expected;
	private List<Directory> actual;
	private Directory root;

	@BeforeEach
	void setUp() {
		File file = new File("fileOne", LocalDateTime.now().minusMinutes(77));
		File fileSub2 = new File("fileSubdir2", LocalDateTime.now().plusMinutes(44));
		File fileSub = new File("fileTwo", LocalDateTime.now());
		Directory subDir2 = new Directory("dirThree", new Directory(), List.of(), List.of(fileSub2));
		Directory subDir = new Directory("dirTwo", subDir2, List.of(subDir2), List.of(fileSub));
		root = new Directory("dirOne", subDir, List.of(subDir), List.of(file));
		expected = new ArrayList<>();
		expected.add(root);
		expected.add(subDir);
		expected.add(subDir2);
	}

	@Test
	void traverseInOrderDirTest() {
		actual = root.traverseInOrder(root, new ArrayList<>());
		assertEquals(expected, actual);
	}

	@Test
	void traverseInOrderFileTest() {
		actual = root.traverseInOrder(root, new ArrayList<>());
		List<File> expectedFiles = expected.stream().map(dir -> {
			int count = 0;
			return dir.getFiles().get(count++);
		}).collect(Collectors.toList());
		List<File> actualFiles = actual.stream().map(dir -> {
			int count = 0;
			return dir.getFiles().get(count++);
		}).collect(Collectors.toList());
		assertEquals(expectedFiles, actualFiles);
	}
}