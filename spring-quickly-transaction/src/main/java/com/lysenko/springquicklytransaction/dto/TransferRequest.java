package com.lysenko.springquicklytransaction.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransferRequest {

    private Long fromAccountId;
    private Long toAccountId;
    private BigDecimal amount;
}
