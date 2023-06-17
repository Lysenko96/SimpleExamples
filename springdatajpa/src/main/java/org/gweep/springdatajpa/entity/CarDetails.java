package org.gweep.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;


@jakarta.persistence.Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_details")
public class CarDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    // link to CarDetails from Car (two-way communication)
    @OneToOne(mappedBy = "carDetails")
    private Car car;

    public CarDetails(String description, Car car) {
        this.description = description;
        this.car = car;
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
