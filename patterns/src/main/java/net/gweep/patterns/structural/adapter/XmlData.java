package net.gweep.patterns.structural.adapter;

public interface XmlData {

	String requestXmlData(String url);

	void responseXmlData(String data);
}
