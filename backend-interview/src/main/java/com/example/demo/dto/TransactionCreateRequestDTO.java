package com.example.demo.dto;

import com.example.demo.model.TransactionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionCreateRequestDTO {

    @JsonProperty(value = "type")
    private TransactionType type;

    @JsonProperty(value = "amount")
    @DecimalMin(value = "0.00", message = "Amount must be greater or equals than 0")
    private BigDecimal amount;

    @JsonProperty(value = "currency")
    private String currency;

    @JsonProperty(value = "reference")
    private String reference;
}
