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
import te.task1.factorybuilder.accessory.Package;

public class Main {

	public static void main(String[] args) {
		Flower rose = new Rose("Rose", 50, LocalDateTime.of(LocalDate.now(), LocalTime.now()), 5);
		Flower mimosa = new Mimosa("Mimosa", 80,
				LocalDateTime.of(LocalDate.now().minusDays(2), LocalTime.now().minusHours(3).minusMinutes(12)), 10);
		Flower tulip = new Tulip("Tulip", 35,
				LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.now().minusHours(2).minusMinutes(5)), 12);
		BouquetBuilder builder = new BouquetBuilder();
		Flower aRose = new Rose("Rose", 55, LocalDateTime.of(LocalDate.now(), LocalTime.now()), 25);
		Flower aMimosa = new Mimosa("Mimosa", 76,
				LocalDateTime.of(LocalDate.now().minusDays(3), LocalTime.now().minusMinutes(65)), 33);
		Accessory newAccessory = new Ribbon(List.of(aRose, aMimosa), 43);
		Bouquet flowersRibbon = builder.setFlower(aRose).setFlower(aMimosa).setFlower(tulip).setAccessory(newAccessory)
				.getBouquet();
		System.out.println(flowersRibbon.sortedByFreshness());
		new Application(flowersRibbon, 20, 35);
		Bouquet bouquetPack = new Bouquet(List.of(rose), List.of((new Package(List.of(rose), 15))));
		Bouquet bouquetRibbon = new Bouquet(List.of(mimosa, tulip), List.of(new Ribbon(List.of(mimosa, tulip), 25)));
		new Application(bouquetPack, 11, 15);
		new Application(bouquetRibbon, 4, 10);
	}
}
