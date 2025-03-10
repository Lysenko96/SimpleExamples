package ua.com.systemgroup.dockerdatabaseserverprovider;

import org.springframework.boot.SpringApplication;
import ua.com.systemgroup.dockerdatabaseserverprovider.config.TestcontainersConfiguration;

public class TestDockerDatabaseServerProviderApplication {

    public static void main(String[] args) {
        SpringApplication.from(DockerDatabaseServerProviderApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
