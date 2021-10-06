package te.task1.factorybuilder;

public interface Builder {

	BouquetBuilder setAccessory(Accessory accessory);

	BouquetBuilder setFlower(Flower flower);
}
