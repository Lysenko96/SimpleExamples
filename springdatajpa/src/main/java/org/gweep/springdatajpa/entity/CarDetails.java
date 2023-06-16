package org.gweep.springdatajpa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_details")
public class CarDetails {

    @Id
    @GeneratedValue
    private long id;
    @Column(name = "car_id")
    private long carId;
    private String description;
    // link to Car from CarDetails (two-way communication)
    @OneToOne
    @JoinColumn(name = "id")
    private Car car;

    public CarDetails(long carId, String description) {
        this.carId = carId;
        this.description = description;
    }

    public CarDetails(long id, long carId, String description) {
        this.id = id;
        this.carId = carId;
        this.description = description;
    }

    @Override
    public String toString() {
        return "CarDetails{" +
                "id=" + id +
                ", carId=" + carId +
                ", description='" + description + '\'' +
                '}';
    }
}
