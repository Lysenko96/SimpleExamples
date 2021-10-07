package gweep.net.allpatterns.creational.singleton;

public class Main {

	public static void main(String[] args) {
		System.out.println(ProductStore.getInstance());
		System.out.println(ProductStore.getInstance());
		ProductStore.getInstance().addProduct(new Product("Milk", 35));
		ProductStore.getInstance().addProduct(new Product("Bread", 15));
		ProductStore.getInstance().getStoreInfo();
	}
}