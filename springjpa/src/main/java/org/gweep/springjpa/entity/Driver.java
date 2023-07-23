package org.gweep.springjpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private List<Car> cars = new ArrayList<>();
   // private List<Car> cars;
    public Driver(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Driver(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Driver(String name, String surname, List<Car> cars) {
        this.name = name;
        this.surname = surname;
        this.cars = cars;
    }

    public void useCar(Car car){
        cars.add(car);
    }


}
