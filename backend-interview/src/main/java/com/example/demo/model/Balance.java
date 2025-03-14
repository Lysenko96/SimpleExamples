package com.example.demo.model;

import java.math.BigDecimal;

public interface Balance {

    long getId();

    BigDecimal getAmount();

    void setAmount(BigDecimal amount);

    String getCurrency();
}
