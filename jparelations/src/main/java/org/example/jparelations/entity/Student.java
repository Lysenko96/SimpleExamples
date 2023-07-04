package org.example.jparelations.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student extends Person {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    private String specialization;

    public Student(String firstName, String lastName, String phone, String email, String specialization) {
        super(firstName, lastName, phone, email);
        this.specialization = specialization;
    }
}
