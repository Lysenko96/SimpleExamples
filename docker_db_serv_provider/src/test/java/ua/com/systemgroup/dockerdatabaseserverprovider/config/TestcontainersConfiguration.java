package ua.com.systemgroup.dockerdatabaseserverprovider.config;

import org.junit.jupiter.api.Test;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
public class TestcontainersConfiguration {

    @Container
    @ServiceConnection
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:17rc1");

    @Test
    void givenContainer_whenGetJdbcUrl_thenCreatedAndRunning() {
        assertTrue(postgres.isCreated());
        assertTrue(postgres.isRunning());
    }

}
