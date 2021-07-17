package edu.lysenko.patterns.structural.decorator;

public class DecoratorMain {

	private static String PATH_TO_FILE = "/home/gweep/eclipse-workspace/patterns/src/main/resources/test.txt";

	public static void main(String[] args) {
		String test = "pattern: Decorator" + System.lineSeparator() + "language: Java";
		DataSourceDecorator encoded = new CompressionDecorator(
				new EncryptionDecorator(new FileDataSource(PATH_TO_FILE)));
		encoded.writeData(test);
		DataSource plain = new FileDataSource(PATH_TO_FILE);
		System.out.println("Input");
		System.out.println(test);
		System.out.println("Encoded");
		System.out.println(plain.readData());
		System.out.println("Decoded");
		System.out.println(encoded.readData());
	}
}
