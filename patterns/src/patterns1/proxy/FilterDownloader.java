package patterns.proxy;

import java.util.Map;

public class FilterDownloader {

	private Filterable api;

	public FilterDownloader(Filterable api) {
		this.api = api;
	}

	public void createPoolIp() {
		Map<String, Integer> connects = api.filter();
		for (Map.Entry<String, Integer> pair : connects.entrySet()) {
			System.out.println("Ip: " + pair.getKey());
			System.out.println("Port: " + pair.getValue());
		}
	}

	public Integer getPordByIp(String ip) {
		return api.filter().get(ip);
	}

}
