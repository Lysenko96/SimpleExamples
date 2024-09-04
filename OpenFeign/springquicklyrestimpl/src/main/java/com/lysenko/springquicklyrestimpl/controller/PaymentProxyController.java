package com.lysenko.springquicklyrestimpl.controller;

import com.lysenko.springquicklyrestimpl.model.Payment;
import com.lysenko.springquicklyrestimpl.rest.PaymentProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
//@RequestMapping("/proxy")
@RequiredArgsConstructor
public class PaymentProxyController {

    private final PaymentProxy paymentProxy;

    private static Logger logger = Logger.getLogger(PaymentProxyController.class.getName());

    @PostMapping("/payment")
    public Payment createPayment(@RequestBody Payment payment) {
        String requestId = UUID.randomUUID().toString();
        logger.info("Proxy request id: " + requestId + " and payment: " + payment);

        return paymentProxy.create(requestId, payment);
    }
}
