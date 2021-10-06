package te.task1.factorybuilder;

import java.util.List;

public interface BouquetFactory {

	Flower findByStemLength(int min, int max);

	int getPrice();

	List<Flower> sortedByFreshness();

}