package org.gweep.springweb.entity;

import org.gweep.springweb.iface.Pet;

public class Person {

    private Pet pet;

    public Person() {
        System.out.println("Created person");
    }

    public Person(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        System.out.println("Set pet");
        this.pet = pet;
    }

    public void callPet(){
        System.out.println("Hi pet!");
        pet.say();
    }
}
