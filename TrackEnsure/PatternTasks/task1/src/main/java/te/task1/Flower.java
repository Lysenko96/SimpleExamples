package te.task1;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Flower {

	protected String name;
	protected int price;
	protected LocalDateTime dateTime;
	protected int stemLength;

	abstract void flowering();
}