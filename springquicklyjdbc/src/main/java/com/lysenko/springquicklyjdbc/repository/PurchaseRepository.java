package com.lysenko.springquicklyjdbc.repository;

import com.lysenko.springquicklyjdbc.model.Purchase;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PurchaseRepository {

    private final JdbcTemplate jdbcTemplate;
    private final DatabasePopulator populator;
    private final DataSource dataSource;

    @PostConstruct
    public void init() {
        DatabasePopulatorUtils.execute(populator, dataSource);
    }

    public void save(Purchase purchase) {
        String sql = "INSERT INTO purchase (name, price) VALUES (?, ?)";

        jdbcTemplate.update(sql, purchase.getName(), purchase.getPrice());
    }

    public List<Purchase> findAll() {
        String sql = "SELECT * FROM purchase";

        RowMapper<Purchase> rowMapper = (rs, rowNum) -> {
            Purchase purchase = new Purchase();
            purchase.setId(rs.getInt("id"));
            purchase.setName(rs.getString("name"));
            purchase.setPrice(rs.getBigDecimal("price"));

            return purchase;
        };

        return jdbcTemplate.query(sql, rowMapper);
    }


}
