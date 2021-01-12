package edu.tasks.lysenko.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
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
}
