package org.example.petproject.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String degree;
    String university;
    @Column(name = "date_from")
    LocalDate dateFrom;
    @Column(name = "date_to")
    LocalDate dateTo;
    @Embedded
    Address address;
    @ManyToOne
    @JoinColumn(name = "resume_id")
    Resume resume;
}
