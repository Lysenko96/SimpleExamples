package net.pack.leetproblems.sortpeople;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.asList(new Solution().sortPeople(new String[]{"Bob", "Alice", "Mike"}, new int[]{120, 140, 130})));
    }

    public String[] sortPeople(String[] names, int[] heights) {
        List<Person> persons = new ArrayList<>();
        String[] result = new String[names.length];
        for(int i = 0; i < names.length; i++)
            persons.add(new Person(names[i], heights[i]));

        persons.sort(Comparator.comparing(Person::getHeight).reversed());
        for(int i = 0; i < persons.size(); i++)
            result[i] = persons.get(i).getName();

        return result;
    }
}

class Person {

    private String name;
    private int height;

    public Person(String name, int height){
        this.name = name;
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return height == person.height && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, height);
    }
}