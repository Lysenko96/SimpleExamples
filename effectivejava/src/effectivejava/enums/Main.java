package effectivejava.enums;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		Operation plus = Operation.PLUS;
		System.out.println(plus.apply(3, 3));
		Operation minus = Operation.MINUS;
		System.out.println(minus.apply(1, 2));
		System.out.println(plus);
		Map<Integer, Integer> map = new HashMap<>();
		map.put(1, 4);
		map.put(2, 11);
		map.merge(2, 3, Integer::sum);
		// {1=4, 2=14}
		System.out.println(map);
	}
}
