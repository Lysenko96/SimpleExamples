package net.gweep.voting.fileworker;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;

import net.gweep.voting.entity.Candidate;
import net.gweep.voting.entity.Citizen;
import net.gweep.voting.entity.Party;
import net.gweep.voting.entity.Station;
import net.gweep.voting.entity.Voting;

public class FileWorker {

	public void writeStations(List<Station> objFile, String output) {
		try (PrintWriter p = new PrintWriter(new FileOutputStream(output, true))) {
			for (int i = 0; i < objFile.size(); i++) {
				p.write(objFile.get(i) + System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void writeCitizens(List<Citizen> objFile, String output) {
		try (PrintWriter p = new PrintWriter(new FileOutputStream(output, true))) {
			for (int i = 0; i < objFile.size(); i++) {
				p.write(objFile.get(i) + System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void writeParties(List<Party> objFile, String output) {
		try (PrintWriter p = new PrintWriter(new FileOutputStream(output, true))) {
			for (int i = 0; i < objFile.size(); i++) {
				p.write(objFile.get(i) + System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void writeCandidates(List<Candidate> objFile, String output) {
		try (PrintWriter p = new PrintWriter(new FileOutputStream(output, true))) {
			for (int i = 0; i < objFile.size(); i++) {
				p.write(objFile.get(i) + System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void writeStrings(List<String> objFile, String output) {
		try (PrintWriter p = new PrintWriter(new FileOutputStream(output, true))) {
			for (int i = 0; i < objFile.size(); i++) {
				p.write(objFile.get(i) + System.lineSeparator());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
