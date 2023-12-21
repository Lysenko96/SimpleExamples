package com.example.javabasic.network.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CustomJsonParser {

    public static void main(String[] args) {
        String json = "{\n" +
                "  \"firstName\": \"Ivan\",\n" +
                "  \"lastName\": \"Pupkin\",\n" +
                "  \"email\": \"ivan.pupkin.info123@gmail.com\"\n" +
                "}";
        CustomJsonParser parser = new CustomJsonParser();
        Person p = parser.jsonToObj(json, Person.class);
        System.out.println(p);
    }

    private <T> T jsonToObj(String json, Class<T> clazz) {
        String[] arr = json.replace("{", "")
                .replace("}", "")
                .replace("\"", "")
                .split(":");
        T result = null;
        try {
           arr = Arrays.stream(arr).map(String::trim).collect(Collectors.joining( ",")).split(",");
            Object[] values = new String[Math.round((float) arr.length /2)];
            int index = 0;
            for (int i = 0; i < arr.length; i++) {
                if(i % 2 != 0) {
                    values[index] = arr[i];
                    index++;
                }
            }
            Class<String>[] types = new Class[values.length];
            for (int i = 0; i < values.length; i++) {
                types[i] = String.class;
            }
            result = clazz.getDeclaredConstructor(types).newInstance(values);
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private static class Person {
        private String firstName;
        private String lastName;
        private String email;
    }
}
