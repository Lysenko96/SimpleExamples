package com.lysenko.springquicklywebclient.service;

import com.lysenko.springquicklywebclient.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentProxy {

    @Value("${name.service.url}")
    private String url;

    private final WebClient webClient;

    public Mono<Payment> createPayment(String requestId, Payment payment) {
        log.info("Create payment with requestId: {}", requestId);

        return webClient.post()
                .uri(url + "/payment")
                .header("requestId", requestId)
                .body(Mono.just(payment), Payment.class)
                .retrieve()
                .bodyToMono(Payment.class);
    }
}
