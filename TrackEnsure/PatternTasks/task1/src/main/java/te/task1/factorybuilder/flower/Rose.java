package te.task1.factorybuilder.flower;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Rose extends Flower {

	public Rose(String name, int price, LocalDateTime dateTime, int stemLength) {
		super(name, price, dateTime, stemLength);
	}

	@Override
	public String toString() {
		String formattedDateTime = dateTime.format(FORMATTER);
		return "Rose [name=" + name + ", price=" + price + ", dateTime=" + formattedDateTime + ", stemLength="
				+ stemLength + "]";
	}
}