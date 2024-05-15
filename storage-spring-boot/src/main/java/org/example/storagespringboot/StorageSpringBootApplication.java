package org.example.storagespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class StorageSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(StorageSpringBootApplication.class, args);
    }

}
