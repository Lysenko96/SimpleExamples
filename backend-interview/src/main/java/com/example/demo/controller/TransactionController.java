package com.example.demo.controller;

import com.example.demo.dto.TransactionCreateRequestDTO;
import com.example.demo.dto.TransactionCreateResponseDTO;
import com.example.demo.dto.TransactionUpdateRequestDTO;
import com.example.demo.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/transaction")
@Validated
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping
    public TransactionCreateResponseDTO create(@RequestBody @Valid final TransactionCreateRequestDTO dto) {
        var transaction = transactionService.create(
                dto.getType(),
                dto.getReference(),
                dto.getAmount(),
                dto.getCurrency()
        );

        return new TransactionCreateResponseDTO(transaction.getId(), transaction.getStatus());
    }

    @PostMapping("update/{id}")
    public TransactionCreateResponseDTO update(@PathVariable Long id, @RequestBody TransactionUpdateRequestDTO dto) throws Exception {
        var transaction = transactionService.update(id, dto.getTransactionStatus());
        return new TransactionCreateResponseDTO(transaction.getId(), transaction.getStatus());
    }
}
