package info.gweep.springtx.service;

import info.gweep.springtx.entity.Car;
import info.gweep.springtx.repository.CarDao;
import info.gweep.springtx.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Service
//@Transactional
// if you use interface CarDao need @EnableTransactionManagement(proxyTargetClass = true)
public class CarService extends CarDao {

    private CarRepository carRepository;

    private TransactionTemplate transactionTemplate;

    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    public CarService(CarRepository carRepository, TransactionTemplate transactionTemplate) {
        this.carRepository = carRepository;
        this.transactionTemplate = transactionTemplate;
    }

    //private static final String CARS_COUNT = "select count(c) from Car c";

    @Override
    public void add(Car car) {
        carRepository.save(car);
    }

    // @Transactional(readOnly = true)
    @Override
    public Car getById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    // @Transactional(readOnly = true)
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

    //   @Override
//    @Transactional(propagation = Propagation.NEVER)
//    public Long countAllCar() {
//        return carRepository.countAllCar();
//    }
//
    public Long countAllCar1() {
        return transactionTemplate.execute(transactionStatus -> entityManagerFactory.createEntityManager().createNamedQuery("Car.COUNT_ALL", Long.class)).getSingleResult();
    }
    @Override
    public Long countAllCar() {
        return transactionTemplate.execute(new TransactionCallback<Long>() {
            @Override
            public Long doInTransaction(TransactionStatus status) {
                return entityManagerFactory.createEntityManager().createNamedQuery("Car.COUNT_ALL", Long.class).getSingleResult();
            }
        });
    }
}
