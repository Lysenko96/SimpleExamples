package net.gweep.junit;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Directory implements Component {

	private String name;
	private Directory next;
	private List<Component> directories;
	private List<File> files;

	void addComponent(Component component) {
		directories.add(component);
	}

	void removeComponent(Component component) {
		directories.remove(component);
	}

	void addFile(File file) {
		files.add(file);
	}

	void removeFile(File file) {
		files.remove(file);
	}

	@Override
	public List<Directory> traverseInOrder(Directory root, List<Directory> dirs) {
		if (root != null && root.getNext() != null && root.getFiles() != null) {
			dirs.add(root);
			traverseInOrder(root.getNext(), dirs);
		}
		return dirs;
	}

	@Override
	public String toString() {
		return "Directory [name=" + name + ", next=" + next + ", directories=" + directories + ", files=" + files + "]";
	}
}