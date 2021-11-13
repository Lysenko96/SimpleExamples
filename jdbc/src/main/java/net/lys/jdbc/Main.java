package net.lys.jdbc;

import net.lys.jdbc.connection.Provider;
import net.lys.jdbc.dao.impl.JdbcCarDao;
import net.lys.jdbc.entity.Car;

public class Main {

	public static void main(String[] args) {
		Provider provider = new Provider();
		JdbcCarDao carDao = new JdbcCarDao(provider);
		System.out.println(carDao.getAll());
		System.out.println(carDao.getById(1));
	//	 carDao.add(new Car("Bmw", 235, 210000));
		// System.out.println(carDao.getAll());
//		carDao.update(new Car(1, "Lamba", 270, 300000));
//		System.out.println(carDao.getAll());
//		carDao.deleteById(2);
//		System.out.println(carDao.getAll());
	}
}