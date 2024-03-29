package net.gweep.task;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		DirFactory root = new DirFactory(new Directory());
		DirFactory dir = new DirFactory(new Directory("dirOne"));
		DirFactory subDir = new DirFactory(new Directory("dirTwo"));
		DirFactory subDirTwo = new DirFactory(new Directory("dirThree"));
		DirFactory subDirNew = new DirFactory(new Directory("dirNew"));
		DirFactory subDirNewTwo = new DirFactory(new Directory("dirNewTwo"));
		subDirNew.getDirectory().addComponent(subDirNewTwo.getDirectory());
		subDir.getDirectory().addComponent(subDirNew.getDirectory());
		subDir.getDirectory().addComponent(subDirTwo.getDirectory());
		dir.getDirectory().addComponent(subDir.getDirectory());
		dir.getDirectory().addFile(new File("fileOne", LocalDateTime.now().minusMinutes(77)));
		subDir.getDirectory().addFile(new File("fileTwo", LocalDateTime.now()));
		subDirTwo.getDirectory().addFile(new File("fileSubOne", LocalDateTime.now().plusMinutes(44)));
		root.getDirectory().addComponent(dir.getDirectory());
		System.out.println(root.getDirectory().accumulate(new ArrayList<>()));
	}
}
