package com.lysenko.springquicklytransaction.service;

import com.lysenko.springquicklytransaction.model.Account;
import com.lysenko.springquicklytransaction.repository.AccountRepository;
import com.lysenko.springquicklytransaction.repository.AccountRepositoryCrud;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TransferService {

    private final AccountRepository accountRepository;
    private final AccountRepositoryCrud accountRepositoryCrud;


    public void transfer(Long fromAccountId, Long toAccountId, BigDecimal amount) {
//        Account sender = accountRepository.findById(fromAccountId);
//        Account receiver = accountRepository.findById(toAccountId);
        Account sender = accountRepositoryCrud.findById(fromAccountId).orElseThrow();
        Account receiver = accountRepositoryCrud.findById(toAccountId).orElseThrow();

        BigDecimal senderNewBalance = sender.getBalance().subtract(amount);
        BigDecimal receiverNewBalance = receiver.getBalance().add(amount);

//        accountRepository.changeBalance(fromAccountId, senderNewBalance);
        accountRepositoryCrud.changeBalance(fromAccountId, senderNewBalance);

//        throw new RuntimeException("Transfer failed");

//        accountRepository.changeBalance(toAccountId, receiverNewBalance);
        accountRepositoryCrud.changeBalance(toAccountId, receiverNewBalance);

    }

    public List<Account> findByName(String name) {
        return accountRepositoryCrud.findByName(name);
    }

    public List<Account> findAllAccounts() {
        return (List<Account>) accountRepositoryCrud.findAll();
//        return accountRepository.findAll();
    }
}
