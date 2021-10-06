package te.task1.factorybuilder.flower;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Mimosa extends Flower {

	public Mimosa(String name, int price, LocalDateTime dateTime, int stemLength) {
		super(name, price, dateTime, stemLength);
	}

	@Override
	public String toString() {
		return "Mimosa [name=" + name + ", price=" + price + ", dateTime=" + dateTime + ", stemLength=" + stemLength
				+ "]";
	}
}