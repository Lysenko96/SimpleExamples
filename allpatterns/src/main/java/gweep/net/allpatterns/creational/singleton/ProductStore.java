package gweep.net.allpatterns.creational.singleton;

import java.util.ArrayList;
import java.util.List;

public class ProductStore {

	private static ProductStore store;
	private static List<Product> products = new ArrayList<>();

	private ProductStore() {
	}

	public static synchronized ProductStore getInstance() {
		if (store == null) {
			store = new ProductStore();
		}
		return store;
	}

	public void addProduct(Product product) {
		products.add(product);
	}

	public void getStoreInfo() {
		System.out.println(products);
	}
}
