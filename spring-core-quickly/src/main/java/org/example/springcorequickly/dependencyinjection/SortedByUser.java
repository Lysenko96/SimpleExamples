package org.example.springcorequickly.dependencyinjection;

public class SortedByUser implements Sorter{

    @Override
    public void sortDetails() {
        System.out.println("SortedByUser");
    }
}
