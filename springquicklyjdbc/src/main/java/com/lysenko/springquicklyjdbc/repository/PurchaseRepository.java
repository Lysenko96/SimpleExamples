package com.lysenko.springquicklyjdbc.repository;

import com.lysenko.springquicklyjdbc.model.Purchase;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
@RequiredArgsConstructor
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;

    public void save(Purchase purchase) {
        String sql = "INSERT INTO purchase (name, price) VALUES (?, ?)";

        jdbcTemplate.update(sql, purchase.getName(), purchase.getPrice());
    }

    @PostConstruct
    public void init() {
        save(new Purchase("spring quickly", new BigDecimal("1.1")));
    }
}
