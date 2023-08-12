package info.gweep.springtx.service;

import info.gweep.springtx.entity.Car;
import info.gweep.springtx.repository.CarDao;
import info.gweep.springtx.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
// if you use interface CarDao need @EnableTransactionManagement(proxyTargetClass = true)
public class CarService extends CarDao {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public void add(Car car) {
        carRepository.save(car);
    }

    @Transactional(readOnly = true)
    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Car> getAll() {
        return carRepository.findAll();
    }

    @Override
    public void update(Car car) {
        carRepository.save(car);
    }

    @Override
    public void deleteById(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }
}
