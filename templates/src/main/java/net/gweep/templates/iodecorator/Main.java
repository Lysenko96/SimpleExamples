package net.gweep.templates.iodecorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

	public static void main(String[] args) {
		int c;
		try (InputStream in = new UpperCaseInputStream(new BufferedInputStream(new FileInputStream("test.txt")))) {
			while ((c = in.read()) >= 0) {
				System.out.print((char) c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}