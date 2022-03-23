package edu.tohaa.carservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int door_counter;
    private String name;
    private int speed;
    private CarType type;

    public Car(int door_counter, String name, int speed, CarType type) {
        this.door_counter = door_counter;
        this.name = name;
        this.speed = speed;
        this.type = type;
    }
}
