package net.gweep.patterns.structural.adapter;

public class XmlAdapterFromJson extends JsonData implements XmlData {

	@Override
	public String requestXmlData(String url) {
		return requestJsonData(url);
	}

	@Override
	public void responseXmlData(String data) {
		responseJsonData(data);
	}
}