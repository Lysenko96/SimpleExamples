package te.task1;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class FlowerOne extends Flower {

	FlowerOne(String name, int price, LocalDateTime dateTime, int stemLength) {
		super(name, price, dateTime, stemLength);
	}

	@Override
	public void flowering() {
		System.out.println(this.getClass().getSimpleName() + " flowering...");
	}

	@Override
	public String toString() {
		return "FlowerOne [name=" + name + ", price=" + price + ", dateTime=" + dateTime + ", stemLength=" + stemLength
				+ "]";
	}
}