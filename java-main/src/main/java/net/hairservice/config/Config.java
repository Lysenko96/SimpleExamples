package net.hairservice.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    @Value("${db.maxConnectionPool}")
    private int maxConnectionPool;

    @Bean
    public DataSource datasource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.setMaximumPoolSize(maxConnectionPool);
        return new HikariDataSource(config);
    }

    @Bean(initMethod = "migrate")
    public Flyway flyway(DataSource dataSource) {
        return Flyway.configure().dataSource(dataSource).load();
    }

    @Bean
    public ResourceDatabasePopulator populator(DataSource dataSource) {
        return new ResourceDatabasePopulator(new ClassPathResource("db/migration/V1__schema.sql"));
    }

    @Bean
    public JdbcTemplate jdbcTemplate(ResourceDatabasePopulator populator, DataSource datasource) {
        DatabasePopulatorUtils.execute(populator, datasource);
        return new JdbcTemplate(datasource);
    }
}