package te.task1.factorybuilder.flower;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Flower {

	protected String name;
	protected int price;
	protected LocalDateTime dateTime;
	protected int stemLength;
	protected static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

	@Override
	public String toString() {
		String formattedDateTime = null;
		if (this.getDateTime() != null) {
			formattedDateTime = dateTime.format(FORMATTER);
		} else {
			formattedDateTime = null;
		}
		return "Flower [name=" + name + ", price=" + price + ", dateTime=" + formattedDateTime + ", stemLength="
				+ stemLength + "]";
	}

}