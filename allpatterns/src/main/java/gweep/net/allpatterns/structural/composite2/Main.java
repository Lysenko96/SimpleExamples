package gweep.net.allpatterns.structural.composite2;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		File file = new File("fileOne", LocalDateTime.now().minusMinutes(77));
		File fileSub2 = new File("fileSubdir2", LocalDateTime.now().plusMinutes(44));
		File fileSub = new File("fileTwo", LocalDateTime.now());
		Directory subDir2 = new Directory("dirThree", new Directory(), List.of(), List.of(fileSub2));
		Directory subDir = new Directory("dirTwo", subDir2, List.of(subDir2), List.of(fileSub));
		Directory root = new Directory("dirOne", subDir, List.of(subDir), List.of(file));
		System.out.println(root.traverseInOrder(root, new ArrayList<>()));
	}
}