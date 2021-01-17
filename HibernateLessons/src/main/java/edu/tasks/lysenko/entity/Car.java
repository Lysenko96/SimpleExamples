package edu.tasks.lysenko.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "cars")
public class Car implements Serializable {

	private static final long serialVersionUID = 1868366807549658624L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "car_id")
	private Integer id;
	@Column(name = "car_model")
	private String model;
	@Column(name = "car_speed")
	private Integer speed;
	@ManyToMany(mappedBy = "setCars")
	private Set<Driver> setDrivers;

	public Car(String model, Integer speed) {
		this.model = model;
		this.speed = speed;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", speed=" + speed + "]";
	}

}
