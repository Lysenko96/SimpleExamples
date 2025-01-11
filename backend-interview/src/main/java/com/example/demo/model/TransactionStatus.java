package com.example.demo.model;

public enum TransactionStatus {

    NEW,
    PROCESSING,
    SUCCESS,
    ERROR;

    public boolean isFinal(TransactionStatus status) {
        return this == status;
    }

}
