package orm.hibernate.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Car")

public class Car implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String model;
	private int speed;
	@ManyToMany(mappedBy = "cars", fetch = FetchType.EAGER)
	private List<Driver> drivers;

	public Car(int id, String model, int speed) {
		this.id = id;
		this.model = model;
		this.speed = speed;
	}

	public Car(String model, int speed) {
		this.model = model;
		this.speed = speed;
	}

	public Car() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public List<Driver> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}

	@Override
	public int hashCode() {
		return Objects.hash(drivers, id, model, speed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Car)) {
			return false;
		}
		Car other = (Car) obj;
		return Objects.equals(drivers, other.drivers) && id == other.id && Objects.equals(model, other.model)
				&& speed == other.speed;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", speed=" + speed + "]";
	}
}
