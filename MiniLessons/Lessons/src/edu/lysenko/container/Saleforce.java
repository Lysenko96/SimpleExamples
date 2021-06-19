package edu.lysenko.container;

import java.util.Arrays;
import java.util.List;

public class Saleforce implements Generator<Company> {

	List<Company> companies = Arrays.asList(new Company("ITSTAR", 75), new Company("Itransaction", 1000));

	private int index;

	@Override
	public Company next() {
		return companies.get(index++);
	}

}

class Company {

	private String name;
	private int size;

	Company() {
	}

	Company(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return "Company [name=" + name + ", size=" + size + "]";
	}

}