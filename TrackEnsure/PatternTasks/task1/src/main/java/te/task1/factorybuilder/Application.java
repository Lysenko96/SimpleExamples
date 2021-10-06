package te.task1.factorybuilder;

import te.task1.factorybuilderiface.BouquetFactory;
import static java.lang.System.out;

public class Application {

	public Application(BouquetFactory factory, int min, int max) {
		out.println("Price: " + factory.getPrice());
		out.println("StemLength: " + factory.findByStemLength(min, max));
		out.println("Sorted: " + factory.sortedByFreshness());
	}
}