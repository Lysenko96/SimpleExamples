package te.task1.factorybuilder;

import te.task1.factorybuilderiface.BouquetFactory;

public class Application {

	public Application(BouquetFactory factory, int min, int max) {
		System.out.println(factory.getPrice());
		System.out.println(factory.findByStemLength(min, max));
		System.out.println(factory.sortedByFreshness());
	}
}