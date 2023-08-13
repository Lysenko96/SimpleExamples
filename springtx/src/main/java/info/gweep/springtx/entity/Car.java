package info.gweep.springtx.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "Car.COUNT_ALL", query = "select count(c) from Car c")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String model;

    public Car(String model) {
        this.model = model;
    }
}
