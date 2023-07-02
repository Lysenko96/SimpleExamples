package org.gweep.springjpa.repository;

import org.gweep.springjpa.entity.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Modifying
    @Query(value = "update  car set updatedate=now() where id = ?1", nativeQuery = true)
    long updateById(long id);

    List<Car> findAllByModelAndSpeedEquals(String model, double speed);

//    @Query(value = "SELECT * FROM car WHERE model = :model AND speed = :speed", nativeQuery = true)
//    List<Car> findAllByModelAndSpeedEqualsNumber(@Param("model") String model, @Param("speed") double speed);
    @Query(value = "FROM Car WHERE model = :model AND speed = :speed")
    List<Car> findAllByModelAndSpeedEqualsNumber(@Param("model") String model, @Param("speed") double speed);
//    @Query(value = "FROM Car WHERE model = ?1 AND speed = ?2")
//    List<Car> findAllByModelAndSpeedEqualsNumber(String model, double speed);

    //@Transactional
    List<Car> findAllByNameAndSpeedAfter(String name, double speed);
    List<Car> findAllByModel(String model);

    @Query(value = "FROM Car WHERE model = ?1")
    List<Car> findAllByModelPageable(String model, Pageable pageable);
    @Query(value = "FROM Car WHERE model = ?1")
    List<Car> findAllByModelSort(String model, Sort sort);
}
