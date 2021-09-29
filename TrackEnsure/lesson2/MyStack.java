package te.lesson2;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

//public class MyStack extends LinkedList<String> implements Stack {
public class MyStack implements Stack {

	private List<String> list = new ArrayList<>();

	@Override
	public void push(String value) {
		list.add(value);
	}

	@Override
	public String pop() {
		return list.remove(list.size() - 1);
	}

	@Override
	public String peek() {
		return list.get(list.size() - 1);
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

}
