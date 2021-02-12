package edu.task.filter;

import java.io.BufferedReader;
import java.io.IOException;

import edu.task.behaviour.BufferedReaderMachine;

public class StringTest implements BufferedReaderMachine {

	@Override
	public String doing(BufferedReader reader) throws IOException {
		return reader.readLine();
	}

}
