package com.example.demo.messaging.kafka;

import com.example.demo.model.TransactionStatus;

import java.math.BigDecimal;

public class Event {

    private long transactionId;
    private TransactionStatus transactionStatus;
    private BigDecimal amount;

    public Event() {
    }

    public Event(long transactionId, TransactionStatus transactionStatus, BigDecimal amount) {
        this.transactionId = transactionId;
        this.transactionStatus = transactionStatus;
        this.amount = amount;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public TransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(TransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
