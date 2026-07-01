package com.example.demo.model;

public interface Transaction {

    long getId();

    Transaction updateStatus(TransactionStatus status);

    TransactionStatus getStatus();
}
