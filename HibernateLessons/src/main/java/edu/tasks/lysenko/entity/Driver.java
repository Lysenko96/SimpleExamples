package edu.tasks.lysenko.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "drivers")
public class Driver implements Serializable {

	private static final long serialVersionUID = 985421871662377196L;
	@Column(name = "driver_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "driver_name")
	private String name;
	@Column(name = "driver_surname")
	private String surname;
	@Column(name = "car_id")
	private int carId;

	@OneToOne(cascade = CascadeType.ALL)
	private Key driver_key;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "driver_cars", joinColumns = @JoinColumn(name = "driver_id"), inverseJoinColumns = @JoinColumn(name = "car_id"))
	private Set<Car> setCars;

	public Driver() {

	}

	public Driver(String name, String surname, int carId, Key driver_key, Set<Car> setCars) {
		this.name = name;
		this.surname = surname;
		this.carId = carId;
		this.driver_key = driver_key;
		this.setCars = setCars;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getCarId() {
		return carId;
	}

	public void setCarId(int carId) {
		this.carId = carId;
	}

	public Key getKey() {
		return driver_key;
	}

	public void setKey(Key driver_key) {
		this.driver_key = driver_key;
	}

	public Set<Car> getSetCars() {
		return setCars;
	}

	public void setSetCars(Set<Car> setCars) {
		this.setCars = setCars;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + carId;
		result = prime * result + id;
		result = prime * result + ((driver_key == null) ? 0 : driver_key.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((setCars == null) ? 0 : setCars.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (carId != other.carId)
			return false;
		if (id != other.id)
			return false;
		if (driver_key == null) {
			if (other.driver_key != null)
				return false;
		} else if (!driver_key.equals(other.driver_key))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (setCars == null) {
			if (other.setCars != null)
				return false;
		} else if (!setCars.equals(other.setCars))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", surname=" + surname + ", carId=" + carId + "]";
	}
}
