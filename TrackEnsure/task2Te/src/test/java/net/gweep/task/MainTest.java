package net.gweep.task;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainTest {

	private List<Component> expected;
	private List<Component> actual;
	private Directory root;

	@BeforeEach
	void setUp() {
		root = new DirFactory(new Directory()).getDirectory();
		DirFactory dir = new DirFactory(new Directory("dirOne"));
		DirFactory subDir = new DirFactory(new Directory("dirTwo"));
		DirFactory subDirTwo = new DirFactory(new Directory("dirThree"));
		subDir.getDirectory().addComponent(subDirTwo.getDirectory());
		dir.getDirectory().addComponent(subDir.getDirectory());
		dir.getDirectory().addFile(new File("fileOne", LocalDateTime.now().minusMinutes(77)));
		subDir.getDirectory().addFile(new File("fileTwo", LocalDateTime.now()));
		subDirTwo.getDirectory().addFile(new File("fileSubOne", LocalDateTime.now().plusMinutes(44)));
		root.addComponent(dir.getDirectory());
		expected = new ArrayList<>();
		expected.add(dir.getDirectory());
		expected.add(subDir.getDirectory());
		expected.add(subDirTwo.getDirectory());
	}

	@Test
	void traverseInOrderDirTest() {
		actual = root.accumulate(new ArrayList<>());
		assertEquals(expected, actual);
	}

	@Test
	void traverseInOrderFileTest() {
		actual = root.accumulate(new ArrayList<>());
		List<File> expectedFiles = expected.stream().map(dir -> {
			int count = 0;
			return ((Directory) dir).getFiles().get(count++);
		}).collect(Collectors.toList());
		List<File> actualFiles = actual.stream().map(dir -> {
			int count = 0;
			return ((Directory) dir).getFiles().get(count++);
		}).collect(Collectors.toList());
		assertEquals(expectedFiles, actualFiles);
	}
}