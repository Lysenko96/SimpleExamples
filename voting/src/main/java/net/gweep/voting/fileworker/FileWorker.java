package net.gweep.voting.fileworker;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

public class FileWorker {

	
	public void writeObjects(List<Object> objFile, String output) {
		try (PrintWriter p = new PrintWriter(new FileOutputStream(output, true))) {
			for (int i = 0; i < objFile.size(); i++) {
				p.write(objFile.get(i) + System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
