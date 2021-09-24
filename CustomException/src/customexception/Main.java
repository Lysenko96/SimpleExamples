package customexception;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	private Map<String, Integer> map = new HashMap<>();

	{
		map.put("Anton", 65);
		map.put("Sergey", 75);
		map.put("Nastya", 53);
		map.put("Sanya", 85);
		map.put("Vlad", 75);
	}

	public static void main(String[] args) {
		Main main = new Main();
		try {
			System.out.println(main.getWeight("1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getWeight(String name) throws CustomException {
		return Stream.of(name).map(key -> {
			if (map.containsKey(name)) {
				return map.get(name);
			} else {
				CustomException exception = new CustomException(System.lineSeparator() + "not found info", 345);
				System.out.println(exception);
				return exception.getResult();
			}
		}).collect(Collectors.toList()).get(0);
	}
}
