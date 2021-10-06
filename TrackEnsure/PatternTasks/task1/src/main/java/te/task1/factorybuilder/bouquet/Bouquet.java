package te.task1.factorybuilder.bouquet;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import te.task1.factorybuilder.bouquet.*;
import te.task1.factorybuilder.accessory.Accessory;
import te.task1.factorybuilder.flower.Flower;
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
		for (Flower flower : flowers) {
			if (flower.getStemLength() >= min && flower.getStemLength() <= max) {
				return flower;
			}
		}
		return null;
	}

	@Override
	public int getPrice() {
		int price = 0;
		for (Accessory accessory : accessories) {
			for (Flower flower : accessory.getFlowers()) {
				price += flower.getPrice();
			}
			price += accessory.getPrice();
		}
		return price;
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