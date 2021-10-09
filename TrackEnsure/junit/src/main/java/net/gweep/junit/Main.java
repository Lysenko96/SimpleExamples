package net.gweep.junit;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Directory root = new Directory("dirOne",
				new Directory("dirTwo", new Directory(), List.of(), List.of(new File("fileTwo", LocalDateTime.now()))),
				List.of(), List.of(new File("fileOne", LocalDateTime.now().minusMinutes(77))));
		new Main().traverseInOrder(root, new ArrayList<>());

	}

	public List<Directory> traverseInOrder(Directory root, List<Directory> dirs) {
		if (root != null && root.getNext() != null && root.getFiles() != null) {
			dirs.add(root);
			System.out.println(root);
			System.out.println(root.getFiles());
			traverseInOrder(root.getNext(), dirs);
		}
		return dirs;
	}

}