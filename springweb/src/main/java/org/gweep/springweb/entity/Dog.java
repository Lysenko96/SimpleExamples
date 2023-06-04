package org.gweep.springweb.entity;

import org.gweep.springweb.iface.Pet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//@Component
//@Scope("singleton") // default scope
//@Scope("prototype")
public class Dog implements Pet {

    @Value("${dog.name}")
    private String name;
    @Value("${dog.age}")
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
    public String bye(){
        return "Bye...";
    }

    // access different public private protected
    //@PostConstruct
    public int init(){
        System.out.println("Hello bean!");
        return 5;
    }

    //@PreDestroy
    public void destroy() {
        System.out.println("Bye bye!");
    }


    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
