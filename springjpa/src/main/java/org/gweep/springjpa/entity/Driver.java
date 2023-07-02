package org.gweep.springjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
//@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String surname;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="car_used",
    joinColumns = @JoinColumn(name = "driver_id"),
    inverseJoinColumns = @JoinColumn(name = "car_id"))
    private Set<Car> cars = new HashSet<>();
    public Driver(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Driver(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public void useCar(Car car){
        cars.add(car);
    }


}
