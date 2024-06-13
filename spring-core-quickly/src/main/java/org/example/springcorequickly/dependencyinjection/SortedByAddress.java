package org.example.springcorequickly.dependencyinjection;

public class SortedByAddress implements Sorter{

    @Override
    public void sortDetails() {
        System.out.println("SortedByAddress");
    }
}
