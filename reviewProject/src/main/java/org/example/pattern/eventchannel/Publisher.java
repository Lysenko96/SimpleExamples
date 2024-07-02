package org.example.pattern.eventchannel;

public interface Publisher {

    void register(User user);
    void remove(User user);
    void notify(String message);
}
