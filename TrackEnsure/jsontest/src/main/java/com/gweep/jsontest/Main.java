package com.gweep.jsontest;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gweep.jsontest.entity.Person;

public class Main {

	public static void main(String[] args) {
		Person p = new Person(1, "Tony");
		List<Person> persons = List.of(p, new Person(3, "John"));
		ObjectMapper mapper = new ObjectMapper();
		List<Person> peoples2 = new ArrayList<>();
		String s = "";
		String s1 = "";
		try {
			s = mapper.writeValueAsString(p);
			s1 = mapper.writeValueAsString(persons);
			Person person = mapper.readValue(s, Person.class);
			System.out.println(person);
			 peoples2 = mapper.readValue(s1, new TypeReference<List<Person>>() {});
			System.out.println();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(s);
		System.out.println(s1);
		System.out.println(peoples2);

	}
}
