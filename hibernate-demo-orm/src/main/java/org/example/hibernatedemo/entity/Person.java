package org.example.hibernatedemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.example.hibernatedemo.orm.annotation.Column;

import javax.persistence.*;

@Entity
@Table(name = "person")
//@org.example.hibernatedemo.orm.annotation.Table(name = "person")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@Column(name = "first_name")
    @Column(name = "first_name")
    private String firstName;
   // @Column(name = "last_name", updatable = false)
    @Column(name = "last_name")
   // @Column(name = "last_name")
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
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
