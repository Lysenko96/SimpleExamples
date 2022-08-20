package net.pack.tohaa;

import net.pack.tohaa.entities.Person;

public class Main {

    public static void main(String[] args) {
        // generate Object.hash(params ...) hashcode = 887503681 for new Instance()
        // default generate idea hashcode = 0 for new Instance()
        System.out.println(new Person().hashCode());
    }
}
