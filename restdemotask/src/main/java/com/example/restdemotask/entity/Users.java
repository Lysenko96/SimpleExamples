package com.example.restdemotask.entity;

import com.example.restdemotask.exception.InvalidArgumentException;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.regex.Pattern;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Users {

    public static long id;
    Long uniqueId;
    String email;
    String firstName;
    String lastName;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    LocalDate birthDate;
    Address address;
    String phone;

    public Users() {
        ++id;
        uniqueId = id;
    }

    public Users(String email, String firstName, String lastName, LocalDate birthDate) {
        validate(email, firstName, lastName, birthDate);
    }

    public Users(String email, String firstName, String lastName, LocalDate birthDate, Address address) {
        validate(email, firstName, lastName, birthDate);
        this.address = address;
    }

    public Users(String email, String firstName, String lastName, LocalDate birthDate, Address address, String phone) {
        validate(email, firstName, lastName, birthDate);
        this.address = address;
        this.phone = phone;
    }

    public Users(String email, String firstName, String lastName, LocalDate birthDate, String phone) {
        validate(email, firstName, lastName, birthDate);
        this.phone = phone;
    }

    public void validate(String email, String firstName, String lastName, LocalDate birthDate) {
        String regexPattern = "^(.+)@(\\S+)$";
        if (patternMatches(email, regexPattern) && birthDate.isBefore(LocalDate.now())) {
            ++id;
            uniqueId = id;
            this.email = email;
            this.firstName = firstName;
            this.lastName = lastName;
            this.birthDate = birthDate;
        } else {
            throw new InvalidArgumentException("Invalid email format or birth date");
        }
    }

    public void setEmail(String email) {
        String regexPattern = "^(.+)@(\\S+)$";
        if (patternMatches(email, regexPattern)) {
            this.email = email;
        } else {
            throw new InvalidArgumentException("Invalid email format");
        }
    }

    public static boolean patternMatches(String email, String regex) {
        return Pattern.compile(regex).matcher(email).matches();
    }

    public void setBirthDate(LocalDate birthDate) {
        if (birthDate != null && birthDate.isBefore(LocalDate.now())) {
            this.birthDate = birthDate;
        } else {
            throw new InvalidArgumentException("Invalid birth date");
        }
    }


    @Override
    public String toString() {
        return "User{" +
                "uniqueId='" + uniqueId + '\'' +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                '}';
    }
}
