package net.hairservice;

import net.hairservice.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.sql.DataSource;

@SpringBootApplication
public class HairServiceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(HairServiceApplication.class, args);
        Config config = ctx.getBean(Config.class);
        DataSource ds = config.datasource();
    }
}
