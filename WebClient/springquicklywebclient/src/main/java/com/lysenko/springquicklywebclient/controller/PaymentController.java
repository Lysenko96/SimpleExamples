package com.lysenko.springquicklywebclient.controller;

import com.lysenko.springquicklywebclient.model.Payment;
import com.lysenko.springquicklywebclient.service.PaymentProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentProxy paymentProxy;

    @PostMapping("/payment")
    public Mono<Payment> createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();

        return paymentProxy.createPayment(requestId, payment);
    }

}
