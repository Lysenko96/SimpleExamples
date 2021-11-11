package net.gweep.voting.fileworker;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

<<<<<<< HEAD
import net.gweep.voting.entity.Candidate;
import net.gweep.voting.entity.Citizen;
import net.gweep.voting.entity.Party;
import net.gweep.voting.entity.Station;

=======
>>>>>>> f08b87392de270d2d0c52e1d7df8b1f9533a857a
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
