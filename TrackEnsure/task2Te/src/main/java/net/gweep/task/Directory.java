package net.gweep.task;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Directory implements Component {

	private String name;
	private List<Component> directories = new ArrayList<>();
	private List<File> files = new ArrayList<>();

	public Directory(String name) {
		this.name = name;
	}

	public void addComponent(Component component) {
		directories.add(component);
	}

	public void removeComponent(Component component) {
		directories.remove(component);
	}

	public void addFile(File file) {
		files.add(file);
	}

	public void removeFile(File file) {
		files.remove(file);
	}

	@Override
	public List<Component> show(List<Component> components) {
		for (Component dir : directories) {
			components.add(dir);
			dir.show(components);
		}
		return components;
	}

	@Override
	public String toString() {
		return "Directory [name=" + name + ", files=" + files + "]";
	}
}