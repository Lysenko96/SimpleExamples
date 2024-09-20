package com.lysenko.springquicklytransaction.controller;

import com.lysenko.springquicklytransaction.dto.TransferRequest;
import com.lysenko.springquicklytransaction.model.Account;
import com.lysenko.springquicklytransaction.service.TransferService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final TransferService transferService;

    @PostMapping("/transfer")
    public void transfer(@RequestBody TransferRequest transferRequest) {
        transferService.transfer(transferRequest.getFromAccountId(),
                transferRequest.getToAccountId(), transferRequest.getAmount());
    }

    @GetMapping("/accounts")
    public List<Account> findAllAccounts(@RequestParam(required = false) String name) {

        return name == null ? transferService.findAllAccounts() :
                transferService.findByName(name);
    }
}
