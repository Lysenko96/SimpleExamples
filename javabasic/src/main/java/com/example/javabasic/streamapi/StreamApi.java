package com.example.javabasic.streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamApi {

    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(new Person("Ivan", "Pupkin"), new Person("Danil", "Kutkin"));
        Stream<String> nameStream = personList.stream().map(Person::getFirstName);
        nameStream.forEach(System.out::println);
        Stream<String> fullNameStream = personList.stream().flatMap(p -> Stream.of(p.getFirstName(), p.getLastName()));
        fullNameStream.forEach(System.out::println);
        Stream.iterate(0, a -> a + 1)
                .limit(10)
                .forEach(System.out::println);
    }
}
