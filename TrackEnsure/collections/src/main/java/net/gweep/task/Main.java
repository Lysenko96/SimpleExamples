package net.gweep.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		String res = "";
		try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				line = br.readLine();
			}
			res = sb.toString();
		}
		String[] words = res.split(" ");
		List<String> l = new ArrayList<>();
		Collections.addAll(l, words);
		Collections.reverse(l);
		try (PrintWriter p = new PrintWriter("output.txt")) {
			for (int i = 0; i < l.size(); i++) {
				p.write(l.get(i) + " ");
			}
		}
	}
}