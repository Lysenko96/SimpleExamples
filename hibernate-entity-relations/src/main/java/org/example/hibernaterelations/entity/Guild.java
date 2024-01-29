package org.example.hibernaterelations.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "guild")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Guild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String name;

    public Guild(String name) {
        this.name = name;
    }

    @Setter(AccessLevel.PRIVATE)
    @ManyToMany(mappedBy = "guilds", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee){
        employee.getGuilds().add(this);
        employees.add(employee);
    }
}
