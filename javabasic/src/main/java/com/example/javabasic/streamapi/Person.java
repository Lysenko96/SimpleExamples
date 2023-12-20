package com.example.javabasic.streamapi;

import java.util.Objects;
import java.util.Optional;

public class Person {

    private String firstName;
    private Optional<String> lastName;

    private Long counter;


    public Person(String firstName, Optional<String> lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return lastName;
    }

    public void setLastName(Optional<String> lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!Objects.equals(firstName, person.firstName)) return false;
        if (!Objects.equals(lastName, person.lastName)) return false;
        return Objects.equals(counter, person.counter);
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (counter != null ? counter.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
