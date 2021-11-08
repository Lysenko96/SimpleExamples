package net.gweep.practice;

import java.util.Objects;

public class Party {

	String name;

	
	public Party() {
		
	}
	
	public Party(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Party)) {
			return false;
		}
		Party other = (Party) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Party [name=" + name + "]";
	}
	
	
}
