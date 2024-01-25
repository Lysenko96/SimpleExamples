package org.example.hibernatedemo.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.hibernatedemo.orm.annotation.Column;

import javax.persistence.*;

@Entity
//@Table(name = "person")
@org.example.hibernatedemo.orm.annotation.Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@Column(name = "first_name")
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    //@Column(name = "last_name")
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
