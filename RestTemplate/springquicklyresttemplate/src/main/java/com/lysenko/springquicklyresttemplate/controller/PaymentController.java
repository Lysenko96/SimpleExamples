package com.lysenko.springquicklyresttemplate.controller;

import com.lysenko.springquicklyresttemplate.model.Payment;
import com.lysenko.springquicklyresttemplate.service.PaymentProxyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentProxyService paymentProxyService;

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        Payment result = paymentProxyService.create(payment);
        log.info("Payment created: {}", result);

        return result;
    }
}
