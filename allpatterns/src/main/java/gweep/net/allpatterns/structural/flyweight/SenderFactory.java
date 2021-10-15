package gweep.net.allpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SenderFactory {

	private static final Map<Integer, Sender> senders = new HashMap<>();

	Sender getBySpeed(int speed) {
		Sender sender = senders.get(speed);
		if (sender == null && speed <= 200) {
			sender = new RoadSender();
			System.out.println("Using road sending...");
		} else if (sender == null && speed >= 200) {
			sender = new SeaSender();
			System.out.println("Using sea sending...");
		}
		senders.put(speed, sender);
		return sender;
	}
}