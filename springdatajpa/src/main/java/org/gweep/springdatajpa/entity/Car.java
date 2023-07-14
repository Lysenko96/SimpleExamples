package org.gweep.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String model;
    private double speed;

    @OneToOne
    @JoinColumn(name = "details_id")
    private CarDetails carDetails;

    public Car(String name, String model, double speed, CarDetails carDetails) {
        this.name = name;
        this.model = model;
        this.speed = speed;
        this.carDetails = carDetails;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", speed=" + speed +
                ", carDetails=" + carDetails +
                '}';
    }
}
