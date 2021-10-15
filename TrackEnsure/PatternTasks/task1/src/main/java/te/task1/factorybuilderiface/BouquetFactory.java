package te.task1.factorybuilderiface;

import java.util.List;

import te.task1.factorybuilder.flower.Flower;

public interface BouquetFactory {

	Flower findByStemLength(int min, int max);

	int getPrice();

	List<Flower> sortedByFreshness();

}