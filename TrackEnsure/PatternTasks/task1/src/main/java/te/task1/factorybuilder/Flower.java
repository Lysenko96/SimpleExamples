package te.task1.factorybuilder;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Flower {

	protected String name;
	protected int price;
	protected LocalDateTime dateTime;
	protected int stemLength;
}