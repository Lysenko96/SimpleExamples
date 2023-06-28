package org.gweep.springjpa.repository;

import org.gweep.springjpa.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

//@Repository
//public abstract class CarTestRepository implements JpaRepository<Car, Long> {
public class CarTestRepository {
    //@Autowired
    private DataSource dataSource;
   // @Autowired
    private PlatformTransactionManager transactionManager;

    public CarTestRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public CarTestRepository(DataSource dataSource, PlatformTransactionManager transactionManager) {
        this.dataSource = dataSource;
        this.transactionManager = transactionManager;
    }
}
