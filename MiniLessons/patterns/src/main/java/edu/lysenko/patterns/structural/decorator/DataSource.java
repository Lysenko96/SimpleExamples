package edu.lysenko.patterns.structural.decorator;

public interface DataSource {

	void writeData(String data);
	
	String readData();
}
