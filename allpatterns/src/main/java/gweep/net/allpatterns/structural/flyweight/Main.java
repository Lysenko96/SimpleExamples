package gweep.net.allpatterns.structural.flyweight;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		SenderFactory factory = new SenderFactory();
		List<Sender> senders = new ArrayList<>();
		senders.add(factory.getBySpeed(222));
		senders.add(factory.getBySpeed(222));
		senders.add(factory.getBySpeed(111));
		senders.add(factory.getBySpeed(111));
		for (Sender s : senders) {
			s.send();
		}
		System.out.println(senders);
	}
}
