package te.task1.factorybuilder.bouquet;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import te.task1.factorybuilder.accessory.Accessory;
import te.task1.factorybuilder.flower.Flower;
import te.task1.factorybuilderiface.BouquetFactory;

import static java.util.stream.Collectors.toList;

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
				.map(allFlowers -> flowers.stream().map(Flower::getPrice).collect(toList()).stream()
						.reduce((all, next) -> all + next).get())
				.findFirst().orElse(0)
				+ accessories.stream().map(Accessory::getPrice).reduce((all, next) -> all + next).orElse(0);
	}

	@Override
	public List<Flower> sortedByFreshness() {
		return flowers.stream().map(Flower::getDateTime).collect(toList()).stream().sorted().collect(toList()).stream()
				.map(dateTime -> flowers.stream().filter(f -> f.getDateTime().equals(dateTime)).findFirst().get())
				.collect(toList());
	}

}