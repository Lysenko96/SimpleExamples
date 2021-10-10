package gweep.net.allpatterns.structural.composite2;

import java.util.List;

public interface Component {

	List<Directory> traverseInOrder(Directory root, List<Directory> dirs);
}
