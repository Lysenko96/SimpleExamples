package edu.tasks.lysenko.dao;

import java.util.List;

import edu.tasks.lysenko.entity.Car;

public interface CarDao {

	void add(Car car);

	Car getById(int id);

	List<Car> getAll();

	void update(Car car);

	void remove(Car car);
}
