package te.task1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bouquet {

	private List<Flower> flowers;
	private List<Accessory> accessories;

	Flower findByStemLength(int min, int max) {
		for (Flower flower : flowers) {
			if (flower.getStemLength() >= min && flower.getStemLength() <= max) {
				return flower;
			}
		}
		return null;
	}

	int getPrice() {
		int price = 0;
		for (Accessory accessory : accessories) {
			for (Flower flower : accessory.getFlowers()) {
				price += flower.getPrice();
			}
			price += accessory.getPrice();
		}
		return price;
	}

	List<Flower> sortedByFreshness() {
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