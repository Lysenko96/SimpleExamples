package net.gweep.templates.iodecorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class UpperCaseInputStream extends FilterInputStream {

	public UpperCaseInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		int c = in.read();
		int result = 0;
		if (c == -1) {
			result = c;
		} else {
			result = Character.toUpperCase((char) c);
		}
		return result;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int result = in.read(b, off, len);
		for (int i = off; i < off + result; i++) {
			b[i] = (byte) Character.toUpperCase((char) b[i]);
		}
		return result;
	}
}