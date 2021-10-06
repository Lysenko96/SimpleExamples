package te.task1.factorybuilder.accessory;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import te.task1.factorybuilder.flower.Flower;

@Data
@EqualsAndHashCode(callSuper = true)
public class Package extends Accessory {

	public Package(List<Flower> flowers, int price) {
		super(flowers, price);
	}

	@Override
	public String toString() {
		return "Package [flowers=" + flowers + ", price=" + price + "]";
	}
}