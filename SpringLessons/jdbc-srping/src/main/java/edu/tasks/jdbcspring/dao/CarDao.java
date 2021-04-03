package edu.tasks.jdbcspring.dao;

import java.util.List;

import edu.tasks.jdbcspring.entity.Car;

public interface CarDao {

	void add(Car car);

	Car getById(int id);

	List<Car> getAll();

	void update(Car car);

	void deleteById(int id);

}
