package org.example.pattern.functiondesign;

public class Main {

    public static void main(String[] args) {
        // 1 class - 1 responsibility
        Printer printer = new Printer();
        Sender sender = new Sender();

        printer.print();
        sender.send();
    }
}
