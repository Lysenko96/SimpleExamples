package gweep.net.allpatterns.structural.flyweight;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoadSender implements Sender {

	@Override
	public void send() {
		System.out.println("Sending product to road...");
	}
}