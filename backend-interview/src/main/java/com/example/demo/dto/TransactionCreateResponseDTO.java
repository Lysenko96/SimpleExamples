package com.example.demo.dto;

import com.example.demo.model.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
public class TransactionCreateResponseDTO {

    @JsonProperty(value = "transaction_id")
    private long transactionId;

    @JsonProperty(value = "status")
    private TransactionStatus transactionStatus;

    @JsonProperty(value = "amount")
    private BigDecimal amount;
}
