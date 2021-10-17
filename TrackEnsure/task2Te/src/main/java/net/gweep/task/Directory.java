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
	private static int counter;

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
	public List<Component> accumulate(List<Component> components) {
		for (Component dir : directories) {
			components.add(dir);
			System.out.println(dir);
			dir.accumulate(components);
		}
		counter++;
		return components;
	}

	@Override
	public String toString() {
		return "Directory [name=" + name + ", files=" + files + "]";
	}

	public static int getCounter() {
		return counter;
	}

	public static void setCounter(int counter) {
		Directory.counter = counter;
	}
}