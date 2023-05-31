package org.gweep.springweb.entity;

import org.gweep.springweb.iface.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {


//    @Autowired
//    @Qualifier(value = "dog")
    private Pet pet;
    private Pet pet2;

    public Person() {
        System.out.println("Created person");
    }

    //@Autowired
    public Person(@Qualifier(value = "cat")Pet pet) {
        this.pet = pet;
    }

    @Autowired // @Autowired cannot have more than one constructor
    public Person(@Qualifier(value = "cat")Pet pet, @Qualifier(value = "dog")Pet pet2) {
        this.pet = pet;
        this.pet2 = pet2;
    }

    public Pet getPet() {
        return pet;
    }
    //@Autowired // can use any method not only setter
    public void setPet(@Qualifier(value = "dog")Pet pet) {
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
