package patterns.proxy;

import java.util.HashMap;
import java.util.Map;

public class IpProxyCache implements Filterable {

	private Filterable service;
	private Map<String, Integer> cache = new HashMap<>();

	public IpProxyCache() {
		this.service = new Filter();
	}

	@Override
	public Map<String, Integer> filter() {
		if (cache.isEmpty()) {
			cache = service.filter();
		} else {
			System.out.println("Retrieved ip from cache");
		}
		return cache;
	}

}
