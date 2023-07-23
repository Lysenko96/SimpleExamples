package org.gweep.springdatajpa.entity;

import lombok.*;
import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "car_details")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
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
