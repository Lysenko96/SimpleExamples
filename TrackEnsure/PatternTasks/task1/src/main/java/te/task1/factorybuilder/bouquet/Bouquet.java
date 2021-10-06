package te.task1.factorybuilder.bouquet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import te.task1.factorybuilder.accessory.Accessory;
import te.task1.factorybuilder.flower.Flower;
import te.task1.factorybuilder.flower.Rose;
import te.task1.factorybuilderiface.BouquetFactory;

@Data
@AllArgsConstructor
public class Bouquet implements BouquetFactory {

	private List<Flower> flowers;
	private List<Accessory> accessories;

	private Bouquet() {
	}

	@Override
	public Flower findByStemLength(int min, int max) {
		return flowers.stream().filter(flower -> flower.getStemLength() >= min && flower.getStemLength() <= max)
				.findFirst().orElse(null);
	}

	@Override
	public int getPrice() {
		return accessories.stream().map(Accessory::getFlowers).collect(Collectors.toList()).stream()
				.map(allFlowers -> flowers.stream().map(Flower::getPrice).collect(Collectors.toList()).stream()
						.reduce((a, b) -> a + b).get()
						+ accessories.stream().map(Accessory::getPrice).findFirst().get())
				.findFirst().orElse(0);
	}

	@Override
	public List<Flower> sortedByFreshness() {
		List<LocalDateTime> dateTimes = new ArrayList<>();
		for (Flower f : flowers) {
			dateTimes.add(f.getDateTime());
		}
		Collections.sort(dateTimes);
		List<Flower> fl = new ArrayList<>();
		for (LocalDateTime ldt : dateTimes) {
			for (Flower f : flowers) {
				if (f.getDateTime().equals(ldt)) {
					fl.add(f);
				}
			}
		}
		return fl;
	}
}