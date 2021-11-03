package net.gweep.patterns.structural.adapter;

public class XmlAdapterFromJsonComposition implements XmlData {

	private JsonData jsonData;

	XmlAdapterFromJsonComposition(JsonData jsonData) {
		this.jsonData = jsonData;
	}

	@Override
	public String requestXmlData(String url) {
		return jsonData.requestJsonData(url);
	}

	@Override
	public void responseXmlData(String data) {
		jsonData.responseJsonData(data);
	}
}