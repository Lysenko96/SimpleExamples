package com.example.demo.model;

import java.math.BigDecimal;

public interface Transaction {

    long getId();

    void updateStatus(TransactionStatus status);

    TransactionStatus getStatus();

    String getReference();

    BigDecimal getAmount();
}
