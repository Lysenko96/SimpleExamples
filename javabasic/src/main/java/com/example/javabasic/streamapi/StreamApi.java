package com.example.javabasic.streamapi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamApi {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("Ivan", Optional.of("Pupkin")), new Person("Ivan", Optional.of("Pupkin")), new Person("Danil", Optional.of("Kutkin")), new Person("Ivan", Optional.of("Mavka")));
        List<Person> result = personList.stream().filter(p -> p.getFirstName().startsWith("I")).collect(Collectors.toList());
        System.out.println(result);
        Map<String, Long> map = new HashSet<>(personList).stream().filter(person -> {
            if (person.getCounter() == null) person.setCounter(1L);
            return person.getCounter() != null;
        }).collect(Collectors.toMap(Person::getFirstName, Person::getCounter, (aLong, aLong2) -> aLong + 1));
        System.out.println(map);
        personList = Arrays.asList(new Person("Ivan", Optional.of("Pupkin")), new Person("Ivan", Optional.of("Pupkin")), new Person("Danil", Optional.of("Kutkin")), new Person("Ivan", Optional.of("Mavka")));
        Map<String, Long> map1 = new HashSet<>(personList).stream().collect(Collectors.groupingBy(Person::getFirstName, Collectors.counting()));
        System.out.println(map1);

        Set<Person> result1 = personList.stream().collect(filtering(p -> p.getFirstName().equals("Ivan"), toSet()));
        Set<String> result2 = personList.stream().collect(filtering(p -> p.getFirstName().equals("Ivan"), mapping(Person::getFirstName, toSet())));
        System.out.println(result1);
        System.out.println(result2);

        Optional<Optional<String>> optional = new StreamApi().findPerson(personList).map(Person::getLastName);
        System.out.println(optional.orElseGet(()-> Optional.of("")).orElse(""));
        Optional<String> optionalFlatmap = new StreamApi().findPerson(personList).flatMap(Person::getLastName);
        System.out.println(optionalFlatmap.orElse(""));


        Stream<String> nameStream = personList.stream().map(Person::getFirstName);
        nameStream.forEach(System.out::print);
        System.out.println();
        Stream<String> fullNameStream = personList.stream().flatMap(p -> Stream.of(p.getFirstName(), String.valueOf(p.getLastName())));
        fullNameStream.forEach(System.out::print);
        System.out.println();
        Stream.iterate(0, a -> a + 1)
                .limit(10)
                .forEach(System.out::print);
    }

    private Optional<Person> findPerson(List<Person> personList){
        return Optional.of(personList.get(0));
    }
}
