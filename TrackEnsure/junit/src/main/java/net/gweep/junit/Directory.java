package net.gweep.junit;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Directory {

	private String name;
	private Directory next;
	private List<Directory> directories;
	private List<File> files;

	@Override
	public String toString() {
		return "Directory [name=" + name + ", next=" + next + ", directories=" + directories + "]";
	}
}