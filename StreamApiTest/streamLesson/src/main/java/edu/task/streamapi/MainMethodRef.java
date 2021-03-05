package edu.task.streamapi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.Predicate;
//import java.util.function.Supplier;

import edu.task.behaviour.TriFunction;
import edu.task.entity.Car;
import edu.task.entity.Computer;
import edu.task.entity.Integrator;

import static java.util.Comparator.comparing;
import static java.lang.System.out;

public class MainMethodRef {

	public static void main(String[] args) {
		List<Car> cars = new ArrayList<>();
		Car car1 = new Car("Tesla", 231.4f);
		Car car2 = new Car("Audi", 131.6f);
		Car car3 = new Car("Lada", 331.1f);
		cars.add(car1);
		cars.add(car3);
		cars.add(car2);
		// use method reference
		cars.sort(comparing(Car::getModel));
		out.println(cars);// [Car [speed=231.4, model=Tesla], Car [speed=131.6, model=Audi], Car
							// [speed=331.1, model=Lada]]
		cars.sort(new CarComparator());
		out.println(cars); // [Car [speed=131.6, model=Audi], Car [speed=231.4, model=Tesla], Car
							// [speed=331.1, model=Lada]]

		// use anonymous class
		cars.sort(new Comparator<Car>() {

			@Override
			public int compare(Car arg0, Car arg1) {
				return arg1.getSpeed().compareTo(arg0.getSpeed());
			}

		});
		out.println(cars); // [Car [speed=331.1, model=Lada], Car [speed=231.4, model=Tesla], Car
							// [speed=131.6, model=Audi]]

		// use lambda
		cars.sort((c1, c2) -> c1.getSpeed().compareTo(c2.getSpeed()));

		out.println(cars); // [Car [speed=131.6, model=Audi], Car [speed=231.4, model=Tesla], Car
							// [speed=331.1, model=Lada]]

		Comparator<Car> carComparator = comparing((cc1) -> cc1.getSpeed());
		// cars.sort(comparing((cc1) -> cc1.getSpeed());
		cars.sort(carComparator.reversed());
		out.println(cars); // [Car [speed=331.1, model=Lada], Car [speed=231.4, model=Tesla], Car
							// [speed=131.6, model=Audi]]
		Car car4 = new Car("Lada", 210.7f);
		cars.add(car4);
		Car car5 = new Car("Tesla", 330.9f);
		cars.add(car5);
		Comparator<Car> carComparatorMethodRef = comparing(Car::getModel).reversed().thenComparing(Car::getSpeed)
				.reversed();
		cars.sort(carComparatorMethodRef);
		out.println(cars); // [Car [speed=131.6, model=Audi], Car [speed=331.1, model=Lada], Car
							// [speed=210.7, model=Lada], Car [speed=231.4, model=Tesla]]
		Predicate<Car> notLada = (myCar) -> !myCar.getModel().equals("Lada");
		Predicate<Car> lada = notLada.negate();
		out.println(lada.test(car3)); // true
		Predicate<Car> tesla = (myNewCar) -> myNewCar.getModel().equals("Tesla");
		// a.or(b).and(c) can be seen as (a || b) && c
		Predicate<Car> teslaMore300 = tesla.and((carTesla) -> carTesla.getSpeed() > 300);
		out.println(tesla.test(car1));// true
		out.println(tesla.test(car5));// true
		out.println(teslaMore300.test(car1));// false
		out.println(teslaMore300.test(car5));// true

		Function<Double, Double> f = x -> x + 1.4;
		Function<Double, Double> g = x -> x * 3.6;
		Function<Double, Double> h = f.andThen(g); // g(f(x))
		out.println(h.apply(1.2d)); // (1.2 + 1.4) * 3.6 = 9.36

		Function<Double, Double> h1 = f.compose(g); // f(g(x))
		// (1.2 * 3.6) + 1.4 = 5.720000000000001
		out.println(h1.apply(1.2d));

		// using andThen

		Function<Integer, Integer> compute = Computer::firstCompute;
		Function<Integer, String> strCompute = compute.andThen(Computer::strTransform);
		Function<Integer, int[]> intCompute = compute.andThen(Computer::strTransform).andThen(Computer::intTransform); // pipeline
		out.println(strCompute.apply(7)); // 0 ƨ
		out.println(intCompute.apply(7)[0]); // 96
		out.println(intCompute.apply(7)[1]); // 472
		// Supplier<Integrator> t = Integrator::new;
		BiFunction<Double, Double, Integrator> t2 = Integrator::new;
		// add to list return 0 if repeat use lambda
		List<Double> l = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			l.add(integrate(t2, 2.5d, 5.1d));
		}
		Predicate<Double> dp = (a) -> a.equals(l.get(1));
		if (dp.test(l.get(0))) {
			l.set(1, 0d);
		}
		out.println(l);
		DoubleFunction<Double> dfNew = (a) -> a + 10d;
		DoubleFunction<Double> dfNewA = (a) -> a;
		out.println(integrateTwo(dfNewA, 1d, 3d)); // add 10 to two args (a + 10, b + 10) in integrateTwo
		out.println(integrateTwo(dfNew, 1d, 3d));
	}

	static Double integrate(BiFunction<Double, Double, Integrator> f, Double a, Double b) {
		Random r = new Random();
		Integrator tg = f.apply(a, b);
		TriFunction<Double, Double, Integer, Double> s = tg::calculate;
		return s.apply(a, b, r.nextInt(2));
	}

	static double integrateTwo(DoubleFunction<Double> df, double a, double b) {
		return (df.apply(a) + df.apply(b)) * (b - a) / 2d;
	}

}

class CarComparator implements Comparator<Car> {
	@Override
	public int compare(Car c0, Car c1) {
		return c0.getSpeed().compareTo(c1.getSpeed());
	}
}
