package te.task1.factorybuilderiface;

import te.task1.factorybuilder.accessory.*;
import te.task1.factorybuilder.bouquet.BouquetBuilder;
import te.task1.factorybuilder.flower.Flower;

public interface Builder {

	BouquetBuilder setAccessory(Accessory accessory);

	BouquetBuilder setFlower(Flower flower);
}
