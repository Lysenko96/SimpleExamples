package te.task1.factorybuilder;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Rose extends Flower {

	Rose(String name, int price, LocalDateTime dateTime, int stemLength) {
		super(name, price, dateTime, stemLength);
	}

	@Override
	public String toString() {
		return "Rose [name=" + name + ", price=" + price + ", dateTime=" + dateTime + ", stemLength=" + stemLength
				+ "]";
	}
}