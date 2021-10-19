package net.gweep.task3.fileworker;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import net.gweep.task3.entity.Car;

public class FileWorker {

	public void write(List<Car> carsToFile, String output) {
		try (PrintWriter p = new PrintWriter(new FileOutputStream(output, true))) {
			for (int i = 0; i < carsToFile.size(); i++) {
				p.write(carsToFile.get(i) + System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
