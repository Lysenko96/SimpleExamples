package edu.tasks.lysenko.dao;

import java.util.List;

import edu.tasks.lysenko.entity.Car;

public interface CarDao {

	void add(Car driver);

	Car getById(int id);

	List<Car> getAll();

	void update(Car driver);

	void removeById(int id);
}
