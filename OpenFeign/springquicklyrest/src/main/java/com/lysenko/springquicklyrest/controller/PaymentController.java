package com.lysenko.springquicklyrest.controller;

import com.lysenko.springquicklyrest.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentController {

    private static Logger logger = Logger.getLogger(PaymentController.class.getName());

    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(@RequestHeader String requestId, @RequestBody Payment payment) {
        payment.setId(UUID.randomUUID().toString());
        logger.info("Create payment with requestId: " + requestId + " and payment: " + payment);

        return ResponseEntity.status(HttpStatus.ACCEPTED)
                .header("requestId", requestId)
                .body(payment);
    }
}
