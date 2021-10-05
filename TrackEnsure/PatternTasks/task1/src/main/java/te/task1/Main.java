package te.task1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		// use factory every flower can have unique accessory
		
		Flower f1 = new FlowerOne("one", 50, LocalDateTime.of(LocalDate.now(), LocalTime.now()), 5);
		Flower f2 = new FlowerTwo("two", 80,
				LocalDateTime.of(LocalDate.now().minusDays(2), LocalTime.now().minusHours(3).minusMinutes(12)), 10);
		Flower f3 = new FlowerThree("three", 35,
				LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.now().minusHours(2).minusMinutes(5)), 12);

		List<Flower> flowers = new ArrayList<>();
		flowers.add(f1);
		flowers.add(f2);
		flowers.add(f3);
		List<Accessory> accessories = new ArrayList<>();
		accessories.add(new Accessory(List.of(f1), 15));
		accessories.add(new Accessory(List.of(f2, f3), 25));
		Bouquet bouquet = new Bouquet(flowers, accessories);
		System.out.println(bouquet.getPrice());
		System.out.println(bouquet);
		bouquet.setFlowers(bouquet.sortedByFreshness());
		System.out.println(bouquet);
		System.out.println(bouquet.findByStemLength(11, 15));

	}
}