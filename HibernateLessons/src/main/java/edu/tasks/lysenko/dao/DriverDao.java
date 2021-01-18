package edu.tasks.lysenko.dao;

import java.util.List;

import edu.tasks.lysenko.entity.Driver;

public interface DriverDao {

	void add(Driver driver);

	Driver getById(int id);

	List<Driver> getAll();

	void update(Driver driver);

	void remove(Driver driver);
}
