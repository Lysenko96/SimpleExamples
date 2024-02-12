package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

@EqualsAndHashCode(of = "cognitoUsername")
@MappedSuperclass // if inheritance only in java not in database structure every table contains cognitoUsername, email
@NoArgsConstructor
public abstract class User {
    @NaturalId //if find in session by ssn key
    @Column(nullable = false, updatable = false, unique = true)
    private String cognitoUsername;
    @Column(nullable = false, unique = true)
    private String email;
}
