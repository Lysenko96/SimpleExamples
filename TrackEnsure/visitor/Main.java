package te.lesson2.visitor;

public class Main {

	public static void main(String[] args) {
		FirstVisitor visitor = new FirstVisitor();
		City city = new City();
		city.accept(visitor);		
	}
}
