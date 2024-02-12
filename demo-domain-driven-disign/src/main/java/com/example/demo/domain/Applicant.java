package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "applicant")
@Getter
@Setter
@NoArgsConstructor
public class Applicant extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String ssn;
    @Embedded // not entity for managed hibernate
    private Address address;
    @Setter(AccessLevel.PRIVATE)
    @ElementCollection // not entity for managed hibernate
    @CollectionTable(name = "applicant_phones", joinColumns = @JoinColumn(name = "applicant_id"),
            indexes = @Index(name = "applicant_phone_id_idx", columnList = "applicant_id"))
    private List<Phone> phones = new ArrayList<>();
}
