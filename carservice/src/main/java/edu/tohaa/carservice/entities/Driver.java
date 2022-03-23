package edu.tohaa.carservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private int phone;
    private String surname;
    private int year;

    public Driver(String name, int phone, String surname, int year) {
        this.name = name;
        this.phone = phone;
        this.surname = surname;
        this.year = year;
    }
}
