package org.example.springproject.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@PropertySource("classpath:application.properties")
public class Config {

    @Value("${db.url}")
    private String url;
    @Value("${db.user}")
    private String user;
    @Value("${db.password}")
    private String password;
    @Value("${db.maxPoolSize}")
    private int maxPoolSize;

    private static final String BCRYPT = "bcrypt";


    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(url);
        config.setUsername(user);
        config.setPassword(password);
        config.setMaximumPoolSize(maxPoolSize);
        return new HikariDataSource(config);
    }

    @Bean
    public ResourceDatabasePopulator populator() {
        return new ResourceDatabasePopulator(new ClassPathResource("schema.sql"));
    }

    @Bean
    public JdbcTemplate jdbcTemplate(ResourceDatabasePopulator populator, DataSource dataSource) {
        DatabasePopulatorUtils.execute(populator, dataSource);
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public DelegatingPasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put(BCRYPT, new BCryptPasswordEncoder());
        return new DelegatingPasswordEncoder(BCRYPT, encoders);
    }
}
