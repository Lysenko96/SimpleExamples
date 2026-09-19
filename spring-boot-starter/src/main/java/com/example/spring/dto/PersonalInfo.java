package com.example.spring.dto;

import java.time.LocalDateTime;


public class PersonalInfo {

    private String firstname;
    private String lastname;
    private LocalDateTime birthDate;

    public PersonalInfo() {
    }

    public PersonalInfo(String firstname, String lastname, LocalDateTime birthDate) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.birthDate = birthDate;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }
}
