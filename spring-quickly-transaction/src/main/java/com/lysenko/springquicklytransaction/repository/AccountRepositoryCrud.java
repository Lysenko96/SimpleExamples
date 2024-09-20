package com.lysenko.springquicklytransaction.repository;

import com.lysenko.springquicklytransaction.model.Account;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface AccountRepositoryCrud extends CrudRepository<Account, Long> {

    @Query("SELECT * FROM account WHERE name = :name")
    List<Account> findByName(String name);

    @Modifying
    @Query("UPDATE account SET balance = :balance WHERE id = :id")
    void changeBalance(Long id, BigDecimal balance);
}
