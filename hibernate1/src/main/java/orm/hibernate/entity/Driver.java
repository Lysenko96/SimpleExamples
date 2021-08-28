package orm.hibernate.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Driver")
public class Driver implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String surname;
	private int phone;
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "Car_Driver", joinColumns = @JoinColumn(name = "driver_id"), inverseJoinColumns = @JoinColumn(name = "car_id"))
	private List<Car> cars;

	public Driver(int id, String name, String surname, int phone, List<Car> cars) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.cars = cars;
	}

	public Driver(String name, String surname, int phone, List<Car> cars) {
		this.name = name;
		this.surname = surname;
		this.phone = phone;
		this.cars = cars;
	}

	public Driver() {

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

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cars, id, name, phone, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Driver)) {
			return false;
		}
		Driver other = (Driver) obj;
		return Objects.equals(cars, other.cars) && id == other.id && Objects.equals(name, other.name)
				&& phone == other.phone && Objects.equals(surname, other.surname);
	}

	@Override
	public String toString() {
		return "Driver [id=" + id + ", name=" + name + ", surname=" + surname + ", phone=" + phone + ", cars=" + cars
				+ "]";
	}
}
