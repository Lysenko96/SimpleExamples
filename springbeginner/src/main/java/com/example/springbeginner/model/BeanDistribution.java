package com.example.springbeginner.model;

public class BeanDistribution {

    private String name;

    public BeanDistribution(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "BeanDistribution{" +
                "name='" + name + '\'' +
                '}';
    }
}
