package com.lysenko.springquicklytransaction.repository;

import com.lysenko.springquicklytransaction.model.Account;
import com.lysenko.springquicklytransaction.repository.mapper.AccountRowMapper;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Types;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    public Account findById(Long id) {
        String sql = "SELECT * FROM account WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new int[]{Types.BIGINT}, new AccountRowMapper());
    }

    public void changeBalance(Long id, BigDecimal balance) {
        String sql = "UPDATE account SET balance = ? WHERE id = ?";

        jdbcTemplate.update(sql, balance, id);
    }

    public List<Account> findAll(){
        String sql = "SELECT * FROM account";

        return jdbcTemplate.query(sql, new AccountRowMapper());
    }
}
