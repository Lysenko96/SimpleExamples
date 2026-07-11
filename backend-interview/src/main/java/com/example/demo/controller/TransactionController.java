package com.example.demo.controller;

import com.example.demo.dto.TransactionCreateRequestDTO;
import com.example.demo.dto.TransactionCreateResponseDTO;
import com.example.demo.dto.TransactionUpdateRequestDTO;
import com.example.demo.messaging.kafka.TransactionListener;
import com.example.demo.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/transaction")
@Validated
public class TransactionController {

    private final TransactionService transactionService;
    private final TransactionListener  transactionListener;

    @PostMapping
    public ResponseEntity<TransactionCreateResponseDTO> create(@RequestBody @Valid final TransactionCreateRequestDTO dto) {
        var transaction = transactionService.create(
                dto.getType(),
                dto.getReference(),
                dto.getAmount(),
                dto.getCurrency()
        );
        transactionListener.onTransactionCreate(transaction);
        if (transaction.getReference().split("_").length > 1 &&
                transaction.getReference().split("_")[0].equals(dto.getReference())) {
            return new ResponseEntity<>(new TransactionCreateResponseDTO(transaction.getId(),
                    transaction.getStatus(), transaction.getAmount()), HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(new TransactionCreateResponseDTO(transaction.getId(), transaction.getStatus(),
                transaction.getAmount()), HttpStatus.CREATED);
    }

    @PostMapping("update/{id}")
    public ResponseEntity<TransactionCreateResponseDTO> update(@PathVariable Long id, @RequestBody TransactionUpdateRequestDTO dto) {
        var transaction = transactionService.update(id, dto.getTransactionStatus());
        transactionListener.onTransactionUpdate(transaction);
        return new ResponseEntity<>(new TransactionCreateResponseDTO(transaction.getId(), transaction.getStatus(),
                transaction.getAmount()), HttpStatus.OK);
    }
}
