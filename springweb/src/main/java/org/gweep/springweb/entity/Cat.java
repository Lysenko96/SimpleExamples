package org.gweep.springweb.entity;

import org.gweep.springweb.iface.Pet;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype")
public class Cat implements Pet {

    public Cat() {
        System.out.println("Created cat");
    }

    @Override
    public void say(){
        System.out.println("Meow-meow");
    }
}
