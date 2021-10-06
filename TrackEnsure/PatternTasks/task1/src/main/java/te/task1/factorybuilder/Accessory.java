package te.task1.factorybuilder;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class Accessory {

	protected List<Flower> flowers;
	protected int price;
}
