package te.task1.factorybuilder.bouquet;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import te.task1.factorybuilder.accessory.Accessory;
import te.task1.factorybuilder.flower.Flower;
import te.task1.factorybuilderiface.BouquetFactory;

import static java.util.stream.Collectors.toList;

import java.util.Collections;
import java.util.Comparator;

@Data
@AllArgsConstructor
public class Bouquet implements BouquetFactory {

	private List<Flower> flowers;
	private List<Accessory> accessories;

	@Override
	public Flower findByStemLength(int min, int max) {
		Flower f = new Flower(null, 0, null, 0);
		return flowers.stream().filter(flower -> flower.getStemLength() >= min && flower.getStemLength() <= max)
				.findFirst().orElse(f);
	}

	@Override
	public int getPrice() {
		return accessories.stream().map(Accessory::getFlowers).collect(toList()).stream()
				.map(allFlowers -> flowers.stream().mapToInt(Flower::getPrice).sum()
						+ accessories.stream().mapToInt(Accessory::getPrice).sum())
				.findFirst().orElse(0);
	}

	@Override
	public List<Flower> sortedByFreshness() {
		Collections.sort(flowers, Comparator.comparing(Flower::getDateTime));
		return flowers;
	}
}