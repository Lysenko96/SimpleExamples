package te.task1.factorybuilder.accessory;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;
import te.task1.factorybuilder.flower.Flower;

@Data
@EqualsAndHashCode(callSuper = true)
public class Pack extends Accessory {

	public Pack(List<Flower> flowers, int price) {
		super(flowers, price);
	}

	@Override
	public String toString() {
		return "Pack [flowers=" + flowers + ", price=" + price + "]";
	}
}