package org.gweep.springdatajpa.entity;

import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region="car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String model;
    private double speed;

//    @OneToOne
//    @JoinColumn(name = "details_id")
//    private CarDetails carDetails;

    public Car(String name, String model, double speed, CarDetails carDetails) {
        this.name = name;
        this.model = model;
        this.speed = speed;
        //this.carDetails = carDetails;
    }

    public Car(String name, String model, double speed) {
        this.name = name;
        this.model = model;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", speed=" + speed +
                '}';
    }
}
