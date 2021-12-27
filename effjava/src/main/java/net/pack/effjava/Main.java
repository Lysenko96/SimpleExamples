package net.pack.effjava;

import net.pack.effjava.builder.Person;
import net.pack.effjava.builder1.BmwStore;
import net.pack.effjava.builder1.CarStore;

import static net.pack.effjava.builder1.CarStore.Trunk.*;

public class Main {

	public static void main(String[] args) {
		Person person = new Person.Builder("name", "surname", 123).email("email@mail").build();
		System.out.println(person);
		CarStore bmwStore = new BmwStore.Builder("BmwStore address").addTrunk(COUPE).addTrunk(SEDAN).build();
		System.out.println(bmwStore);
	}
}