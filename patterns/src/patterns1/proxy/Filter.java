package patterns.proxy;

import java.util.HashMap;
import java.util.Map;

public class Filter implements Filterable {

	@Override
	public Map<String, Integer> filter() {
		return getRandomIp();
	}

	
	private Map<String, Integer> getRandomIp(){
		Map<String, Integer> map = new HashMap<>();
		map.put("127.0.0.1", 8080);
		map.put("192.168.1.1", 53);
		map.put("10.233.5.1", 22);
		return map;
	}
	
}
