package com.lysenko.springquicklyrestimpl.rest;

import com.lysenko.springquicklyrestimpl.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "payment", url = "${name.service.url}")
public interface PaymentProxy {

    @PostMapping("/payment")
    Payment create(@RequestHeader String requestId,
                   @RequestBody Payment payment);
}
