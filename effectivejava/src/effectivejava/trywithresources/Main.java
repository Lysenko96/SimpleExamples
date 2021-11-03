package effectivejava.trywithresources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {

	private static final int BUFFER_SIZE = 128;

	public static void main(String[] args) throws IOException {
		copy("/home/gweep/eclipse-workspace/effectivejava/file.txt", "/home/gweep/eclipse-workspace/effectivejava/file1.txt");
	}

	static void copy(String src, String dst) throws IOException {
		try (InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
			byte[] buf = new byte[BUFFER_SIZE];
			int n;
			while ((n = in.read(buf)) >= 0)
				out.write(buf, 0, n);
		}
	}
}