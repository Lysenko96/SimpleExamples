package net.gweep.task;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainCountTest {

	private List<Component> expected;
	private List<Component> actual;
	private Directory root;

	@BeforeEach
	void setUp() {
		root = new DirFactory(new Directory("root")).getDirectory();
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
	void countAccumulateTest() {
		System.out.println(root);
		actual = root.accumulate(new ArrayList<>());
		actual.add(root);
		assertEquals(actual.size(), Directory.getCounter());
	}

}
