package orm.hibernate.dao;

import java.util.List;

import orm.hibernate.entity.Driver;

public interface DriverDao {

	void save(Driver driver);

	Driver getById(int id);

	List<Driver> getAll();

	void update(Driver driver);

	void deleteById(int id);
}
