package net.gweep.junit;

import java.util.List;

public interface Component {

	List<Directory> traverseInOrder(Directory root, List<Directory> dirs);
}