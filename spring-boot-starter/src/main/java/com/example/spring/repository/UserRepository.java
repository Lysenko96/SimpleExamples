package com.example.spring.repository;

import com.example.spring.beanpostprocessor.InjectBean;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@ToString
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Repository
public class UserRepository {

//    @InjectBean
//    @Autowired
//    @Resource(name = "connPool2")
//    @Qualifier("connPool")
    private ConnectionPool connPool;

    @Value("${db.poolSize}")
    private String poolSize;

//    @Autowired
    private List<ConnectionPool> connectionPoolList;

//    public UserRepository(ConnectionPool connectionPool1, String poolSize, List<ConnectionPool> connectionPoolList) {
//        this.connPool = connectionPool1;
//        this.poolSize = poolSize;
//        this.connectionPoolList = connectionPoolList;
//    }
//
    public UserRepository(ConnectionPool connPool) {
        this.connPool = connPool;
    }
}
