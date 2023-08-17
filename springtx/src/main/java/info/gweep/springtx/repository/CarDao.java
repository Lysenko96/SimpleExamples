package info.gweep.springtx.repository;

import info.gweep.springtx.entity.Car;

import java.util.List;


public abstract class CarDao {

    public abstract void add(Car car);

    public abstract Car getById(Long id);

    public abstract List<Car> getAll();

    public abstract void update(Car car);

    public abstract void deleteById(Long id);

    public abstract void delete(Car car);

    public abstract Long countAllCar();
}
