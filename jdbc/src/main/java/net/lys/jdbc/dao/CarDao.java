package net.lys.jdbc.dao;

import java.util.List;

import net.lys.jdbc.entity.Car;

public interface CarDao {

	void add(Car car);

	Car getById(int id);

	List<Car> getAll();

	int update(Car car);

	void deleteById(int id);
}
