package net.gweep.patterns.structural.adapter;

public class JsonData {

	String requestJsonData(String url) {
		return url + " data";
	}

	void responseJsonData(String data) {
		System.out.println("sending... " + data);
	}
}