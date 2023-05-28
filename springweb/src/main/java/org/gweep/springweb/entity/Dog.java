package org.gweep.springweb.entity;

import org.gweep.springweb.iface.Pet;

public class Dog implements Pet {

    private String name;
    private int age;

    public Dog() {
        System.out.println("Created dog");
    }

    public Dog(String name, int age) {
        System.out.println("Created dog");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("Set name");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Set age");
        this.age = age;
    }

    @Override
    public void say(){
        System.out.println("Bow-wow");
    }
}
