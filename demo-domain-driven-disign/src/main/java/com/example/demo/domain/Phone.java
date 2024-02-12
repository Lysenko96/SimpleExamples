package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Phone {

    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;

    enum Type {
        HOME, WORK, MOBILE
    }
}
