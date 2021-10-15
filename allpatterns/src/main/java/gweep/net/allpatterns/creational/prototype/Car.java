package gweep.net.allpatterns.creational.prototype;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Copyable {

	private int id;
	private String model;
	private int speed;

	@Override
	public Object copy() {
		return new Car(id, model, speed);
	}
}