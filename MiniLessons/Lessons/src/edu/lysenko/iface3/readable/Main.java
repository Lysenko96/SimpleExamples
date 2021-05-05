package edu.lysenko.iface3.readable;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class Main implements Readable {

	private int count;
	private static Random rand = new Random();
	private static final char[] lowers = "abcdefgfhijklmnopqrstuvwwxyz".toCharArray();

	Main(int count) {
		this.count = count;
	}

	public static void main(String[] args) {
		try (Scanner s = new Scanner(new Main(10));) {
			while (s.hasNext()) {
				System.out.println(s.next());
			}
		}
	}

	@Override
	public int read(CharBuffer cb) throws IOException {
		if (count-- == 0) {
			return -1;
		} else {
			cb.append(lowers[rand.nextInt(lowers.length)]);
		}
		cb.append(" ");
		return 1;
	}

}
