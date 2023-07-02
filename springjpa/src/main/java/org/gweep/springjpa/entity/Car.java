package org.gweep.springjpa.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.Modifying;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
//@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String model;
    private String name;
    private double speed;
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "cars")
    private Set<Driver> drivers = new HashSet<>();
//    @CreationTimestamp
//    private LocalDateTime createDate;
//
//    @UpdateTimestamp
//    private LocalDateTime updateDate;

    public Car(String model, String name, double speed) {
        this.model = model;
        this.name = name;
        this.speed = speed;
    }

    public Car(long id, String model, String name, double speed) {
        this.id = id;
        this.model = model;
        this.name = name;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", name='" + name + '\'' +
                ", speed=" + speed +
                '}';
    }
}
