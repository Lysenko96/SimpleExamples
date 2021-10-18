package net.gweep.test;

import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) {
		
	}
	
	public List<Person> findKids(List<Person> people){
		return people.stream().filter(p -> p.getAge() < 18).collect(Collectors.toList());
	}
}
