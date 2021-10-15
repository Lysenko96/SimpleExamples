package te.task1.factorybuilder.bouquet;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import te.task1.factorybuilder.accessory.Accessory;
import te.task1.factorybuilder.flower.Flower;

@Data
public class BouquetBuilder {

	private static List<Accessory> accessories = new ArrayList<>();
	private static List<Flower> flowers = new ArrayList<>();
	private static Builder builder;

	private BouquetBuilder() {
	}

	public static class Builder {

		private Builder() {
		}

		public static Builder setAccessory(Accessory accessory) {
			accessories.add(accessory);
			return builder;
		}

		public static Builder setFlower(Flower flower) {
			flowers.add(flower);
			return builder;
		}

		public static Bouquet getBouquet() {
			return new Bouquet(flowers, accessories);
		}
	}
}