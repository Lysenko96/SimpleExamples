package te.task1.factorybuilder;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Package extends Accessory {

	Package(List<Flower> flowers, int price) {
		super(flowers, price);
	}

	@Override
	public String toString() {
		return "Package [flowers=" + flowers + ", price=" + price + "]";
	}
}