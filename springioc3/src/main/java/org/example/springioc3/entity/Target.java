package org.example.springioc3.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Target {

    Foo fooImplOne;
    Foo fooImplTwo;
    Bar bar;
// autowire by constructor
//    public Target(Foo fooImplOne, Foo fooImplTwo, Bar bar) {
//        this.fooImplOne = fooImplOne;
//        this.fooImplTwo = fooImplTwo;
//        this.bar = bar;
//    }


    @Autowired
    // autowire by name
    @Qualifier("fooImplOne1")
    public void setFooImplOne(Foo fooImplOne) {
        this.fooImplOne = fooImplOne;
    }

    @Autowired
    @Qualifier("fooImplTwo2")
    public void setFooImplTwo(Foo fooImplTwo) {
        this.fooImplTwo = fooImplTwo;
    }

    @Autowired
    // autowire by type
    public void setBar(Bar bar) {
        this.bar = bar;
    }

    @Override
    public String toString() {
        return "Target{" +
                "fooImplOne=" + fooImplOne +
                ", fooImplTwo=" + fooImplTwo +
                ", bar=" + bar +
                '}';
    }
}
