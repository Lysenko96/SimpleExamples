package info.gweep.springtx.repository;

import info.gweep.springtx.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query("select count(c) from Car c")
    Long countAllCar();
}
