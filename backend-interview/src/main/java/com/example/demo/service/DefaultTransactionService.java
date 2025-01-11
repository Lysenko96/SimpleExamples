package com.example.demo.service;

import com.example.demo.model.Balance;
import com.example.demo.model.Transaction;
import com.example.demo.model.TransactionStatus;
import com.example.demo.model.TransactionType;
import com.example.demo.repository.TransactionRepository;
import com.example.demo.repository.entity.TransactionEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@Component
@RequiredArgsConstructor
@Transactional
public class DefaultTransactionService implements TransactionService {

    private final BalanceService balanceService;
    private final TransactionRepository transactionRepository;

    @Override
    public Transaction create(
            final TransactionType type,
            final String reference,
            final BigDecimal amount,
            final String currency
    ) {
        Balance balance = balanceService.getOrCreate(currency);
        if (type.equals(TransactionType.WITHDRAWAL)) {
            balance.setAmount(balance.getAmount().subtract(amount));
        } else if (type.equals(TransactionType.DEPOSIT)) {
            balance.setAmount(balance.getAmount().add(amount));
        }
        TransactionEntity transactionEntity = transactionRepository.findByReference(reference);
        TransactionEntity transactionEntitySave = new TransactionEntity(
                balance.getId(),
                reference,
                type,
                amount,
                currency
        );

        if (transactionEntity != null) {
            String newReference = reference + "_" + UUID.randomUUID();
            transactionEntitySave.setReference(newReference);
            transactionRepository.save(transactionEntitySave);
            throw new DataIntegrityViolationException("Transaction with " + reference +
                    " already exists create transaction with reference " + newReference);
        }

        return transactionRepository.save(transactionEntitySave);
    }

    @Override
    public Transaction toSuccess(long id) {
        TransactionEntity transactionEntity = transactionRepository.findById(id).orElseThrow();
        if (!transactionEntity.getStatus().isFinal(TransactionStatus.SUCCESS)) {
            transactionEntity.setStatus(TransactionStatus.SUCCESS);
        }
        return transactionEntity;
    }

    @Override
    public Transaction toError(long id) {
        TransactionEntity transactionEntity = transactionRepository.findById(id).orElseThrow();
        if (!transactionEntity.getStatus().isFinal(TransactionStatus.ERROR)) {
            transactionEntity.setStatus(TransactionStatus.ERROR);
        }
        return transactionEntity;
    }

    @Override
    public Optional<Transaction> find(long id) {
        return transactionRepository.findById(id).map(x -> x);
    }
}
