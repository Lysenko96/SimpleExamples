package te.task1.factorybuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import te.task1.factorybuilder.bouquet.Bouquet;
import te.task1.factorybuilder.bouquet.BouquetBuilder;
import te.task1.factorybuilder.flower.Flower;
import te.task1.factorybuilder.flower.Mimosa;
import te.task1.factorybuilder.flower.Rose;
import te.task1.factorybuilder.flower.Tulip;
import te.task1.factorybuilder.accessory.*;

public class Main {

	public static void main(String[] args) {
		Flower tulip = new Tulip("Tulip", 35,
				LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.now().minusHours(2).minusMinutes(5)), 12);
		Flower aRose = new Rose("Rose", 55, LocalDateTime.of(LocalDate.now(), LocalTime.now()), 25);
		Flower aMimosa = new Mimosa("Mimosa", 76,
				LocalDateTime.of(LocalDate.now().minusDays(3), LocalTime.now().minusMinutes(65)), 33);
		Accessory newAccessory = new Ribbon(List.of(aRose, aMimosa), 43);

		Bouquet flowersRibbon = BouquetBuilder.Builder.setFlower(aRose).setFlower(aMimosa).setFlower(tulip)
				.setAccessory(newAccessory).getBouquet();

		new Application(flowersRibbon, 20, 35);
	}
}