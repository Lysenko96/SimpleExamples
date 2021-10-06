package te.task1.factorybuilder.accessory;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import te.task1.factorybuilder.flower.Flower;

@Data
@EqualsAndHashCode(callSuper = true)
public class Ribbon extends Accessory {

	public Ribbon(List<Flower> flowers, int price) {
		super(flowers, price);
	}

	@Override
	public String toString() {
		return "Ribbon [flowers=" + flowers + ", price=" + price + "]";
	}
}