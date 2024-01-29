package org.example.hibernaterelations.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @ToString.Exclude
    @Setter(AccessLevel.PRIVATE)
    @ManyToMany
    @JoinTable(name = "employees_guilds",
    // if change employee_id and guild_id, worked but error mapping
    joinColumns = @JoinColumn(name = "employee_id"),
    inverseJoinColumns = @JoinColumn(name = "guild_id"))
    List<Guild> guilds = new ArrayList<>();

}
