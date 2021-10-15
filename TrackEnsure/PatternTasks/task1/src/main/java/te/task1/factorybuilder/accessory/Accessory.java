package te.task1.factorybuilder.accessory;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import te.task1.factorybuilder.flower.Flower;

@Data
@AllArgsConstructor
public abstract class Accessory {

	protected List<Flower> flowers;
	protected int price;
}
