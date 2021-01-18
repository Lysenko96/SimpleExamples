package edu.tasks.lysenko.hibernate;

import java.util.HashSet;
import java.util.Set;

import edu.tasks.lysenko.dao.impl.CarDaoImpl;
import edu.tasks.lysenko.dao.impl.DriverDaoImpl;
import edu.tasks.lysenko.dao.impl.KeyDaoImpl;
import edu.tasks.lysenko.entity.Car;
import edu.tasks.lysenko.entity.Driver;
import edu.tasks.lysenko.entity.Key;

public class Main {

	public static void main(String[] args) {

		CarDaoImpl carDao = new CarDaoImpl();
		DriverDaoImpl driverDao = new DriverDaoImpl();
		KeyDaoImpl keyDao = new KeyDaoImpl();
		Car car = new Car("Sauber Mercedes", 405);
		Car car1 = new Car("Porsche", 385);
		Set<Car> setCars = new HashSet<>();
		Set<Car> setCars1 = new HashSet<>();
		setCars.add(car);
		setCars1.add(car1);
		Set<Driver> setDrivers = new HashSet<>();
		Set<Driver> setDrivers1 = new HashSet<>();
		Key key = new Key("Sauber Mercedes key");
		Key key1 = new Key("Porsche key");
		Driver driver = new Driver("Michael", "Schumacher", key, setCars);
		Driver driver1 = new Driver("Mark Alan", "Webber", key1, setCars1);
		setDrivers.add(driver);
		setDrivers1.add(driver1);
		car.setSetDrivers(setDrivers);
		car1.setSetDrivers(setDrivers1);
		carDao.add(car);
		carDao.add(car1);
		keyDao.add(key);
		keyDao.add(key1);
		driverDao.add(driver);
		driverDao.add(driver1);
		System.out.println(driverDao.getAll());
		System.out.println(keyDao.getAll());
		System.out.println(carDao.getAll());
		System.out.println(carDao.getAll().get(0).getSetDrivers());
		System.out.println(carDao.getAll().get(1).getSetDrivers());
		key1 = new Key(key1.getId(), "Ferrari key");
		keyDao.update(key1);
		driverDao.remove(driver);
		System.out.println(keyDao.getAll());
		System.out.println(driverDao.getAll());
		System.out.println(carDao.getAll());
		System.out.println(carDao.getAll().get(0).getSetDrivers());
	}
}
