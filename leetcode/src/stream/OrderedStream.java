package stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderedStream {

	private int n;
	List<String> s = new ArrayList<>();
	List<Integer> indexes = new ArrayList<>();
	List<Integer> indexes2 = new ArrayList<>();

	boolean f = false;

	public OrderedStream(int n) {
		this.n = n;
		for (int i = 0; i < n; i++) {
			indexes2.add(0);
		}
	}

	public List<String> insert(int idKey, String value) {
		s.add(value);
		Collections.sort(s);
		indexes.add(idKey);
		Collections.sort(indexes);
		indexes2.set(idKey - 1, idKey);
		return null;
	}

	public static void main(String[] args) {
		OrderedStream stream = new OrderedStream(5);
		stream.insert(3, "ccccc");
		stream.insert(1, "aaaaa");
		stream.insert(2, "bbbbb");
		stream.insert(5, "eeeee");
		stream.insert(4, "ddddd");
	}
}
