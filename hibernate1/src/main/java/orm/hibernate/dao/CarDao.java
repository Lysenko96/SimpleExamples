package orm.hibernate.dao;

import java.util.List;

import orm.hibernate.entity.Car;

public interface CarDao {

	void save(Car car);

	Car getById(int id);

	List<Car> getAll();

	void update(Car car);

	void deleteById(int id);
}
