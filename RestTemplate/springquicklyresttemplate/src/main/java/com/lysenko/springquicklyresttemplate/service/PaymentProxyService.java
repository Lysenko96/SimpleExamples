package com.lysenko.springquicklyresttemplate.service;

import com.lysenko.springquicklyresttemplate.model.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentProxyService {

    private final RestTemplate restTemplate;
    @Value("${name.service.url}")
    private String paymentServiceUrl;

    public Payment create(Payment payment) {
        String uri = paymentServiceUrl + "/payment";

        HttpHeaders headers = new HttpHeaders();
        headers.add("requestId", UUID.randomUUID().toString());

        HttpEntity<Payment> request = new HttpEntity<>(payment, headers);

        ResponseEntity<Payment> response = restTemplate.postForEntity(uri, request, Payment.class);

        return response.getBody();
    }

}
