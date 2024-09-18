package com.lysenko.springquicklytransaction.repository.mapper;

import com.lysenko.springquicklytransaction.model.Account;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {

    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        Account account = new Account();
        account.setId(rs.getObject("id", Long.class));
        account.setName(rs.getString("name"));
        account.setBalance(rs.getBigDecimal("balance"));

        return account;
    }
}
