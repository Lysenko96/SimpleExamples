package net.gweep.patterns.structural.adapter;

public class Main {

	public static void main(String[] args) {
		XmlData adapter = new XmlAdapterFromJson();
		System.out.println(adapter.requestXmlData("https://google.com"));
		adapter.responseXmlData("data");
		XmlData adapter2 = new XmlAdapterFromJsonComposition(new JsonData());
		System.out.println(adapter2.requestXmlData("https://oracle.com"));
		adapter2.responseXmlData("jdk-openjdk-11");
	}
}
