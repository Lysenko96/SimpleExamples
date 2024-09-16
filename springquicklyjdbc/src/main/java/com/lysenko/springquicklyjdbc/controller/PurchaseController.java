package com.lysenko.springquicklyjdbc.controller;

import com.lysenko.springquicklyjdbc.model.Purchase;
import com.lysenko.springquicklyjdbc.repository.PurchaseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchase")
@RequiredArgsConstructor
public class PurchaseController {

    private final PurchaseRepository purchaseRepository;

    @PostMapping
    public void storePurchase(@RequestBody Purchase purchase) {
        purchaseRepository.save(purchase);
    }

    @GetMapping
    public List<Purchase> findAllPurchases() {
        return purchaseRepository.findAll();
    }
}
