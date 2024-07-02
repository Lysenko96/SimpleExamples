package org.example.pattern.eventchannel;

public class User {

    private String name;
    private Publisher publisher;

    public User(String name, Publisher publisher) {
        this.name = name;
        this.publisher = publisher;
        publisher.register(this);
    }

    public void update(String message) {
        System.out.println(name + " read news: " + message);
    }
}
