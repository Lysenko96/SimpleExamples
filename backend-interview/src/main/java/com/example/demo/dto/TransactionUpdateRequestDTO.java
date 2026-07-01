package com.example.demo.dto;

import com.example.demo.model.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TransactionUpdateRequestDTO {

    @JsonProperty(value = "status")
    private TransactionStatus transactionStatus;
}
