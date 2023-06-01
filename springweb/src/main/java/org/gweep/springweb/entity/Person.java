package org.gweep.springweb.entity;

import org.gweep.springweb.iface.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component
public class Person {


//    @Autowired
//    @Qualifier(value = "dog")
    private Pet pet;
    private Pet pet2;

    public Person() {
        System.out.println("Created person");
    }

    public Person(Pet pet) {
        System.out.println("Created person pet");
        this.pet = pet;
    }

    //@Autowired
//    public Person(@Qualifier("cat")Pet pet) {
//        System.out.println("cat @Autowired");
//        this.pet = pet;
//    }
//
    //@Autowired // @Autowired cannot have more than one constructor
    // @Qualifier cannot use pre constructor
//    public Person(@Qualifier("cat")Pet pet, @Qualifier("dog")Pet pet2) {
//        System.out.println("cat-dog @Autowired");
//        this.pet = pet;
//        this.pet2 = pet2;
//    }

    public Pet getPet() {
        return pet;
    }
    //@Autowired // can use any method not only setter
    public void setPet(@Qualifier("dog")Pet pet) {
        System.out.println("Set pet");
        this.pet = pet;
    }

    public void callPet() {
        System.out.println("Hi pet!");
        pet.say();
    }

    public void callAllPet(){
        System.out.println("Hi pets!");
        pet.say();
        pet2.say();
    }
}
