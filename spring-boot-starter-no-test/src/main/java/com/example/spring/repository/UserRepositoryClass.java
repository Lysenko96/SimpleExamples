package com.example.spring.repository;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;

@ToString
@NoArgsConstructor
@Setter
@AllArgsConstructor
@Repository
public class UserRepositoryClass {

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
    public UserRepositoryClass(ConnectionPool connPool) {
        this.connPool = connPool;
    }
}
