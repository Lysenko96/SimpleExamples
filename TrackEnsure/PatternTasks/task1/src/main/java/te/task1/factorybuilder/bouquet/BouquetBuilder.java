package te.task1.factorybuilder.bouquet;

import java.util.ArrayList;
import java.util.List;

import te.task1.factorybuilder.accessory.Accessory;
import te.task1.factorybuilder.flower.Flower;
import te.task1.factorybuilderiface.Builder;

public class BouquetBuilder implements Builder {

	private List<Accessory> accessories = new ArrayList<>();
	private List<Flower> flowers = new ArrayList<>();

	@Override
	public BouquetBuilder setAccessory(Accessory accessory) {
		this.accessories.add(accessory);
		return this;
	}

	@Override
	public BouquetBuilder setFlower(Flower flower) {
		this.flowers.add(flower);
		return this;
	}

	public Bouquet getBouquet() {
		return new Bouquet(flowers, accessories, new ArrayList<>());
	}

}