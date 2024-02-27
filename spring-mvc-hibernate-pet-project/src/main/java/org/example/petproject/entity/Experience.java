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
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "job_title")
    String jobTitle;
    @Column(name = "company_Name")
    String companyName;
    @Column(name = "date_from")
    LocalDate dateFrom;
    @Column(name = "date_to")
    LocalDate dateTo;
    Address address;
    @Column(name = "company_description")
    String companyDescription;
    @Column(name = "acquired_skill")
    String acquiredSkill;
    @ManyToOne
    @JoinColumn(name = "resume_id")
    Resume resume;
}
