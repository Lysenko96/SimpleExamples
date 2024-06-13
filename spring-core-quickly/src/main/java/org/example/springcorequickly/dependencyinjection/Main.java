package org.example.springcorequickly.dependencyinjection;

public class Main {

    public static void main(String[] args) {
        Sorter sorterByAddress = new SortedByAddress();
        Sorter sorterByUser = new SortedByUser();
        DeliveryDetailsPrinter deliveryDetailsPrinter = new DeliveryDetailsPrinter(sorterByAddress);
        DeliveryDetailsPrinter deliveryDetailsPrinter1 = new DeliveryDetailsPrinter(sorterByUser);
        deliveryDetailsPrinter.printDetails();
        deliveryDetailsPrinter1.printDetails();
    }
}
